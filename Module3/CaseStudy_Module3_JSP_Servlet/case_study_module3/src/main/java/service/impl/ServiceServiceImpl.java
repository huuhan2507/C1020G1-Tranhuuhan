package service.impl;

import bean.services.Service;
import repository.ServiceRepository;
import repository.impl.ServiceRepositoryImpl;
import service.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    ServiceRepository repository = new ServiceRepositoryImpl();
    @Override
    public List<Service> showService() {
        return repository.showService();
    }

    @Override
    public void createService(Service service) {
        repository.createService( service );
    }

    @Override
    public void editService(Service service) {
        repository.editService( service );
    }

    @Override
    public void deleteService(Integer id) {
        repository.deleteService( id );
    }

    @Override
    public Service findServiceById(Integer id) {
        return repository.findServiceById( id );
    }

    @Override
    public List<Service> findServiceByName(String search) {
        return repository.findServiceByName( search );
    }
}
