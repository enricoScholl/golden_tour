package it.golden_tour.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.golden_tour.dto.UtenteDto;
import it.golden_tour.entities.UtenteVo;
import it.golden_tour.repo.UtenteRepository;
import it.golden_tour.utils.UtenteUtils;

@Service("utenteService")
public class UtenteServiceImpl implements UtenteService {
	
	@Autowired
    private UtenteRepository utenteRepository;
	
	@Override
    public void saveUser(UtenteVo user) throws Exception {
        utenteRepository.newUser(user);
    }
	
	@Override
    public UtenteDto login(String username, String password) throws Exception {
		
		UtenteVo vo = utenteRepository.login(username, password);
		return vo != null ? UtenteUtils.fromVoToDto(vo) : null;
       
    }


}
