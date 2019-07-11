package it.golden_tour.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.golden_tour.dto.PacchettoDto;
import it.golden_tour.dto.UtenteDto;
import it.golden_tour.entities.PacchettoVo;
import it.golden_tour.entities.ProdottoVo;
import it.golden_tour.entities.UtenteVo;
import it.golden_tour.repo.AdminRepository;
import it.golden_tour.repo.PacchettoRepository;
import it.golden_tour.utils.PacchettoUtils;
import it.golden_tour.utils.UtenteUtils;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminRepository adminRepository;
	@Autowired
	private PacchettoRepository pacchettoRepository;
	
	@Override
    public List<UtenteDto> listaClienti(Long id) throws Exception {
		List<UtenteDto> listaClientiDto = new ArrayList<UtenteDto>();
		if(adminRepository.isAdmin(id)) {
			List<UtenteVo> listaClientiVo = adminRepository.listaClienti();
			for (UtenteVo c: listaClientiVo) {
				UtenteDto dto = UtenteUtils.fromVoToDto(c);
				listaClientiDto.add(dto);
			}
		return listaClientiDto;
		}
        	
        else 
        	return null;
    }
    
    @Override
    public void updateCliente(UtenteVo cliente, Long id) throws Exception {
    	if(adminRepository.isAdmin(id))
    		adminRepository.updateCliente(cliente);
    }
    
    @Override
    public void deleteCliente(UtenteVo cliente, Long id) throws Exception {
        if(adminRepository.isAdmin(id))
        	adminRepository.deleteCliente(cliente);
    }
    
    @Override
    public List<ProdottoVo> listaProdotti(Long id) throws Exception {
        if(adminRepository.isAdmin(id))
        	return adminRepository.listaProdotti();
        else return null;
    }
    
    @Override
    public void updateProdotto(ProdottoVo prodotto, Long id) throws Exception {
    	if(adminRepository.isAdmin(id))
    		adminRepository.updateProdotto(prodotto);
    }
    
    @Override
    public void deleteProdotto(ProdottoVo prodotto, Long id) throws Exception {
    	if(adminRepository.isAdmin(id))
    		adminRepository.deleteProdotto(prodotto);
    }
    
    @Override
	public List<PacchettoDto> getAllPacchetti(Long id) throws Exception {
    	List<PacchettoDto> listaPacchettiDto = new ArrayList<PacchettoDto>();
    	if(adminRepository.isAdmin(id)) {
    		List<PacchettoVo> listaPacchettiVo = pacchettoRepository.getAllPacchetti();
    		for (PacchettoVo p: listaPacchettiVo) {
				PacchettoDto dto = PacchettoUtils.fromVoToDto(p);
				listaPacchettiDto.add(dto);
			}
    	return listaPacchettiDto;
    	}
    		else 
    			return null;
    }
}
