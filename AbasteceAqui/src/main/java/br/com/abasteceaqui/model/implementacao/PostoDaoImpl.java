package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Posto;
import br.com.abasteceaqui.model.interfaces.InterfacePostoDao;

public class PostoDaoImpl implements InterfacePostoDao<Posto> {

	public void salvar(Posto posto) {
		PersistenciaDAO.getInstance().salvar(posto);
	}

	public void atualizar(Posto posto) {
		PersistenciaDAO.getInstance().atualizar(posto);
	}

	public Posto buscarPorCodigo(Integer codigo) {
		@SuppressWarnings("rawtypes")
		List lista = PersistenciaDAO.getInstance().listar("SELECT p FROM Posto p WHERE p.id=" + codigo);

		if (!lista.isEmpty()) {
			return (Posto) lista.get(0);
		}
		return null;
	}

	public void deletar(Posto posto) {
		PersistenciaDAO.getInstance().deletar(posto);
	}

	@SuppressWarnings("unchecked")
	public List<Posto> listar() {
		return PersistenciaDAO.getInstance().listar("SELECT p FROM Posto p");
	}

	public Posto buscarPorCnpj(String cnpj) {
		@SuppressWarnings("rawtypes")
		List lista = PersistenciaDAO.getInstance().listar("SELECT p FROM Posto p WHERE p.cnpj=" + cnpj);

		if (!lista.isEmpty()) {
			return (Posto) lista.get(0);
		}
		return null;
	}

}
