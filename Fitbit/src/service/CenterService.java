package service;

import model.*;
import repository.BaseCenterRepository;
import repository.CenterRepository;
import strategy.SlotAvailabilityStrategy;
import util.CenterUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static service.BookingService.WAITING_LINK_CAPACITY;

public class CenterService {

    CenterRepository centerRepository = new BaseCenterRepository();
    UserService userService = new UserService();

    BookingService bookingService = new BookingService();

    SlotService slotService = new SlotService();

    public void addCenter(String name, String city, List<String> daysClosedList, Integer maxSlots)  {
        Center center = CenterUtil.createCenter(name, city, daysClosedList, maxSlots);
        centerRepository.addCenter(center);
    }

    public void addWorkout(String centerName, String workout) {
        Center center = centerRepository.getCenter(centerName);
        List<Workout> workoutList = center.getWorkouts();
        workoutList.add(new Workout(workout));
    }

    public void addSlot(String centerName, String workout, LocalDateTime startTime, LocalDateTime endTime, int totalSeats) {
        Center center = centerRepository.getCenter(centerName);
        Long slotId = slotService.addSlot(startTime, endTime, totalSeats, workout);
        center.getSlots().add(slotId);
    }

    public Boolean deleteSlot(String centerName, Long id) {
        Center center = centerRepository.getCenter(centerName);
        List<Long> slotIdList = center.getSlots();
        List<Slot> slots = slotService.getSlots(slotIdList);
        Slot slot1=null;
        for (Slot slot: slots) {
            if (slot.getId().equals(id)) {
                slot1=slot;
                break;
            }
        }
        slotIdList.remove(slot1);
        return true;
    }

    public Map<String, List<Slot>> getWorkoutDetails(String centerName, String workout) {
        Center center = centerRepository.getCenter(centerName);
        List<Long> slotIdList = center.getSlots();
        List<Slot> slotList = slotService.getSlots(slotIdList);
        return slotList.stream()
                .filter(slot -> workout.equals(slot.getWorkoutType()))
                .collect(Collectors.groupingBy(Slot::getWorkoutType));
    }

    public List<Slot> getAvailableSlots(String centerName, LocalDate date){
        Center center = centerRepository.getCenter(centerName);
        String day = date.getDayOfWeek().toString();
        if(center.getDaysClosedList().contains(day.toLowerCase())) {
            return new ArrayList<>();
        }
        List<Long> slotIdList = center.getSlots();
        List<Slot> slotList = slotService.getSlots(slotIdList);
        return slotList.stream()
                .filter(slot -> slot.getAvailableSeats() >= 0)
                .filter(slot -> date.equals(slot.getStartTime().toLocalDate()))
                .collect(Collectors.toList());
    }

    public List<Slot> getAvailableSlot(String centerName, String date) {
        Center center = centerRepository.getCenter(centerName);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Parse the string date to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        String day = localDate.getDayOfWeek().toString();
        System.out.println(day);
        //SlotAvailabilityStrategy personaStrategy = new SlotAvailabilityStrategy();
//        List<Slot> result = new ArrayList<>();
//        List<Slot> slotList = slotService.getSlots(center.getSlots());
//        for(Slot slot: slotList) {
//            if (isSlotAvailable(slot)) {
//                if (personaStrategy.isSlotAvailable(slot, rangeStart, rangeEnd) && (slot.getAvailableSeats()>0 || slot.getWailingList().size()<WAITING_LINK_CAPACITY)) {
//                    result.add(slot);
//                }
//            }
//        }
        return slotService.getSlots(center.getSlots());
    }

    private boolean isSlotAvailable(Slot slot, Long userId) {
        User user = userService.getUser(userId);
        return true;
    }

    private Map<String, List<Slot>> getSlotsByWorkOutType(String workoutType, String centerName) {
        Map<String, List<Slot>> allSlots = new HashMap<>();
        Center center = centerRepository.getCenter(centerName);
        List<Long> slotIdList = center.getSlots();
        List<Slot> slotList = slotService.getSlots(slotIdList);
        for (Slot slot : slotList) {
            String type = slot.getWorkoutType();
            if (type.equals(workoutType)) {
                if(!allSlots.containsKey(type))
                    allSlots.put(workoutType, new ArrayList<>());
                allSlots.get(workoutType).add(slot);
            }
        }
        return allSlots;
    }

    public Long bookSlot(Long userId, String centerName, Long slotId) {
        User user = userService.getUser(userId);
        return bookingService.bookSlot(centerName, slotId, user);
    }
}
