package repository;

import model.Center;

import java.util.List;

public interface CenterRepository {

    public Center getCenter(String centerName);

    public void addCenter(Center center);

    public List<Center> getCenterList();

}
