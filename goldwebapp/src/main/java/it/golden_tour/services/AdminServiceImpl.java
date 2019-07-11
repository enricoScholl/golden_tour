package it.golden_tour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.golden_tour.entities.ProdottoVo;
import it.golden_tour.entities.UtenteVo;
import it.golden_tour.repo.AdminRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminRepository adminRepository;
	
	@Override
    public List<UtenteVo> listaClienti(Long id) throws Exception {
        adminRepository.isAdmin(id);
        return adminRepository.listaClienti();
    }
    
    @Override
    public void updateCliente(UtenteVo cliente, Long id) throws Exception {
        adminRepository.isAdmin(id);
        adminRepository.updateCliente(cliente);
    }
    
    @Override
    public void deleteCliente(UtenteVo cliente, Long id) throws Exception {
        adminRepository.isAdmin(id);
        adminRepository.deleteCliente(cliente);
    }
    
    @Override
    public List<ProdottoVo> listaProdotti(Long id) throws Exception {
        adminRepository.isAdmin(id);
        return adminRepository.listaProdotti();
    }
    
    @Override
    public void updateProdotto(ProdottoVo prodotto, Long id) throws Exception {
        adminRepository.isAdmin(id);
        adminRepository.updateProdotto(prodotto);
    }
    
    @Override
    public void deleteProdotto(ProdottoVo prodotto, Long id) throws Exception {
        adminRepository.isAdmin(id);
        adminRepository.deleteProdotto(prodotto);
    }


}
