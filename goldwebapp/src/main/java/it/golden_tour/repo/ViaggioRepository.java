package it.golden_tour.repo;

import java.util.List;

import it.golden_tour.entities.ViaggioVo;

public interface ViaggioRepository {
	
void insertViaggio(ViaggioVo viaggio) throws Exception;
	
	void deleteViaggio(ViaggioVo viaggio) throws Exception;
	
	void updateViaggio(ViaggioVo viaggio) throws Exception;
	
	List<ViaggioVo> getAllViaggi(Long id) throws Exception;

}
