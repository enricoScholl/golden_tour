package it.golden_tour.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.golden_tour.entities.ProdottoVo;
import it.golden_tour.entities.UtenteVo;
import it.golden_tour.services.JDBCService;

@Repository(value= "adminRepository")
public class AdminRepositoryImpl implements AdminRepository {
	
		@Autowired
		private JDBCService databaseService;
	
		@Override
		public boolean isAdmin(Long id) {
		
		Connection connection = null;
		boolean isAdmin = false;
		String query = "select u.* from sys.utente u join sys.tipologia_utente t on u.id_tipologia = t.id_tipologia_utente where id_utente = ? and id_tipologia = 1";
		
		try {
			
			connection = databaseService.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.executeQuery();
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				isAdmin = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdmin;
	}

		@Override
		public List<UtenteVo> listaClienti(Long id) {
			
			List<UtenteVo> lista = new ArrayList<UtenteVo>();
			Connection connection = null;
			String query = "select * from sys.utente where id_tipologia = 2";
				
				try {
					
					connection = databaseService.getDatabaseConnection();
					
					PreparedStatement ps = connection.prepareStatement(query);
					
					ResultSet rs = ps.executeQuery();
					
					UtenteVo cliente = new UtenteVo();
					
					while(rs.next()) {
						cliente.setId(rs.getLong("id_utente"));
						cliente.setNome(rs.getString("nome_utente"));
						cliente.setCognome(rs.getString("cognome_utente"));
						cliente.setUsername(rs.getString("username_utente"));
						lista.add(cliente);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return lista;
		}

		@Override
		public void updateCliente(UtenteVo cliente) {
			
			Connection connection = null;
			String query = "update sys.utente set id_tipologia = ?, nome_utente = ?, cognome_utente = ?, username = ?, password = ? where id_utente = ?";
			try {
				
					connection = databaseService.getDatabaseConnection();
					
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.executeUpdate();
					ps.setLong(1, cliente.getTipologia());
					ps.setString(2, cliente.getNome());
					ps.setString(3, cliente.getCognome());
					ps.setString(4, cliente.getUsername());
					ps.setString(5, cliente.getPassword());
					ps.setLong(6, cliente.getId());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void deleteCliente(UtenteVo cliente) {
			
			Connection connection = null;
			String query = "delete from sys.utente where id_utente = ?";
			
			try {
				
					connection = databaseService.getDatabaseConnection();
					
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setLong(1, cliente.getId());
					
					ps.executeUpdate();
					
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}

		@Override
		public List<ProdottoVo> listaProdotti() {
			
			Connection connection = null;
			String query = "select * from sys.utente where id_tipologia = 2";
			List<ProdottoVo> lista = new ArrayList<ProdottoVo>();
				
				try {
					
					connection = databaseService.getDatabaseConnection();
					
					PreparedStatement ps = connection.prepareStatement(query);
					
					ResultSet rs = ps.executeQuery();
					
					ProdottoVo prodotto = new ProdottoVo();
					
					while(rs.next()) {
						
						prodotto.setId(rs.getLong("id_prodotto"));
						prodotto.setDescrizione(rs.getString("ds_descrizione"));
						
						lista.add(prodotto);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return lista;
		}

		@Override
		public void updateProdotto(ProdottoVo prodotto) {
			
			Connection connection = null;
			String query = "update sys.prodotto set ds_prodotto = ? where id_prodotto = ?";
			try {
				
					connection = databaseService.getDatabaseConnection();
					
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.executeUpdate();
					ps.setString(1, prodotto.getDescrizione());
					ps.setLong(2, prodotto.getId());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void deleteProdotto(ProdottoVo prodotto) {
			
			Connection connection = null;
			String query = "delete from sys.utente where id_utente = ?";
			
			try {
				
					connection = databaseService.getDatabaseConnection();
					
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setLong(1, prodotto.getId());
					
					ps.executeUpdate();
					
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}	
}
