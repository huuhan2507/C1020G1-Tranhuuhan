package repository.impl;

import bean.services.RentType;
import bean.services.Service;
import bean.services.ServiceType;
import repository.ServiceRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    public static final String SHOW_SERVICE = "select * from service s " +
            "inner join  rent_type r on r.rent_type_id = s.rent_type_id " +
            "inner join  service_type t on t.service_type_id = s.service_type_id";
    public static final String SEARCH_SERVICE = "select * from service s " +
            "inner join  rent_type r on r.rent_type_id = s.rent_type_id " +
            "inner join  service_type t on t.service_type_id = s.service_type_id where service_name like concat('%',?,'%');";

    public static final String CREATE_SERVICE = "call create_service(?,?,?,?,?,?,?,?,?,?);";
    public static final String UPDATE_SERVICE = "call update_service(?,?,?,?,?,?,?,?,?,?,?);";
    public static final String ONE_SERVICE = "select * from service s " +
            "inner join  rent_type r on r.rent_type_id = s.rent_type_id " +
            "inner join  service_type t on t.service_type_id = s.service_type_id where service_id = ?";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Service> showService() {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SHOW_SERVICE );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Service service = new Service();
                service.setServiceId( resultSet.getInt( 1 ) );
                service.setServiceName( resultSet.getString( 2 ) );
                service.setServiceArea( resultSet.getInt( 3 ) );
                service.setServiceCost( resultSet.getDouble( 4 ) );
                service.setServiceMaxPeople( resultSet.getInt( 5 ) );
                service.setRentType( new RentType( resultSet.getInt( 12 ),
                        resultSet.getString( 13 ), resultSet.getDouble( 14 ) ) );
                service.setServiceType( new ServiceType( resultSet.getInt( 15 ), resultSet.getString( 16 ) ) );
                service.setStandardRoom( resultSet.getString( 8 ) );
                service.setDescriptionOtherConvenience( resultSet.getString( 9 ) );
                service.setAreaPool( resultSet.getDouble( 10 ) );
                service.setNumberOfFloors( resultSet.getInt( 11 ) );
                serviceList.add( service );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public void createService(Service service) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall( CREATE_SERVICE );
            callableStatement.setString( 1, service.getServiceName() );
            callableStatement.setInt( 2, service.getServiceArea() );
            callableStatement.setDouble( 3, service.getServiceCost() );
            callableStatement.setInt( 4, service.getServiceMaxPeople() );
            callableStatement.setInt( 5, service.getRentType().getRentTypeId() );
            callableStatement.setInt( 6, service.getServiceType().getServiceTypeId() );
            callableStatement.setString( 7, service.getStandardRoom() );
            callableStatement.setString( 8, service.getDescriptionOtherConvenience() );
            callableStatement.setDouble( 9, service.getAreaPool() );
            callableStatement.setInt( 10, service.getNumberOfFloors() );
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editService(Service service) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall( UPDATE_SERVICE );
            callableStatement.setInt( 1, service.getServiceId() );
            callableStatement.setString( 2, service.getServiceName() );
            callableStatement.setInt( 3, service.getServiceArea() );
            callableStatement.setDouble( 4, service.getServiceCost() );
            callableStatement.setInt( 5, service.getServiceMaxPeople() );
            callableStatement.setInt( 6, service.getRentType().getRentTypeId() );
            callableStatement.setInt( 7, service.getServiceType().getServiceTypeId() );
            callableStatement.setString( 8, service.getStandardRoom() );
            callableStatement.setString( 9, service.getDescriptionOtherConvenience() );
            callableStatement.setDouble( 10, service.getAreaPool() );
            callableStatement.setInt( 11, service.getNumberOfFloors() );
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteService(Integer id) {

    }

    @Override
    public Service findServiceById(Integer id) {
        Service service = new Service();
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall( ONE_SERVICE );
            callableStatement.setString( 1,String.valueOf( id ) );
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                service.setServiceId( resultSet.getInt( 1 ) );
                service.setServiceName( resultSet.getString( 2 ) );
                service.setServiceArea( resultSet.getInt( 3 ) );
                service.setServiceCost( resultSet.getDouble( 4 ) );
                service.setServiceMaxPeople( resultSet.getInt( 5 ) );
                service.setRentType( new RentType( resultSet.getInt( 12 ),
                        resultSet.getString( 13 ), resultSet.getDouble( 14 ) ) );
                service.setServiceType( new ServiceType( resultSet.getInt( 15 ), resultSet.getString( 16 ) ) );
                service.setStandardRoom( resultSet.getString( 8 ) );
                service.setDescriptionOtherConvenience( resultSet.getString( 9 ) );
                service.setAreaPool( resultSet.getDouble( 10 ) );
                service.setNumberOfFloors( resultSet.getInt( 11 ) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return service;
    }

    @Override
    public List<Service> findServiceByName(String search) {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SEARCH_SERVICE );
            preparedStatement.setString( 1, search );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Service service = new Service();
                service.setServiceId( resultSet.getInt( 1 ) );
                service.setServiceName( resultSet.getString( 2 ) );
                service.setServiceArea( resultSet.getInt( 3 ) );
                service.setServiceCost( resultSet.getDouble( 4 ) );
                service.setServiceMaxPeople( resultSet.getInt( 5 ) );
                service.setRentType( new RentType( resultSet.getInt( 12 ),
                        resultSet.getString( 13 ), resultSet.getDouble( 14 ) ) );
                service.setServiceType( new ServiceType( resultSet.getInt( 15 ), resultSet.getString( 16 ) ) );
                service.setStandardRoom( resultSet.getString( 8 ) );
                service.setDescriptionOtherConvenience( resultSet.getString( 9 ) );
                service.setAreaPool( resultSet.getDouble( 10 ) );
                service.setNumberOfFloors( resultSet.getInt( 11 ) );
                serviceList.add( service );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }
}
