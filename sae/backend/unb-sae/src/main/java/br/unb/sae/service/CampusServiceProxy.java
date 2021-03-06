package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.erlangms.EmsServiceProxy;
import br.unb.sae.vo.CampusVo;

@Stateless
public class CampusServiceProxy extends EmsServiceProxy {

	public CampusVo findById(Integer id){
		return getStream().from("/sitab/campus/:id")
				.setParameter(id)
				.request()
				.getObject(CampusVo.class);
	}

	
	public List<CampusVo> getListaCampus(){
		List<CampusVo> lista = getStream().from("/sitab/campus")
							.request()
							.toList(CampusVo.class);
		
		return lista;
	}

	public List<Object> find(String filter, String sort){
		List<Object> lista = getStream().from("/sitab/campus")
								.setQuery("filter", filter)
								.setQuery("sort", sort)
								.request()
								.toList();
		return lista;
	}


	public List<Object> getListaAluno() {
		return getStream().from("/sigra/aluno")
				.request()
				.toList();
	}
	
}
