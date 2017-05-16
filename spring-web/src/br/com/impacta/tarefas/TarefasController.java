package br.com.impacta.tarefas;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.impacta.dao.TarefaDao;
import br.com.impacta.tarefas.model.Tarefa;

@Controller
public class TarefasController {

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		TarefaDao dao = new TarefaDao();
		dao.adiciona(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		TarefaDao dao = new TarefaDao();
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		TarefaDao dao = new TarefaDao();
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		TarefaDao dao = new TarefaDao();
		model.addAttribute("tarefa", dao.pesquisar(id));
		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		TarefaDao dao = new TarefaDao();
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}

}