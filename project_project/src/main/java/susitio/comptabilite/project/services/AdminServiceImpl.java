package susitio.comptabilite.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import susitio.comptabilite.project.dao.AdminRepository;
import susitio.comptabilite.project.entities.Admin;

import java.util.List;

public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(int id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }
}
