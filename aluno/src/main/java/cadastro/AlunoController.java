package cadastro;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/alucontroller", "/AlunoServlet", "/AlunoController", "/AlunoController.do" })
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Pegar a lista
		GerenciadorAluno ga = new GerenciadorAluno();
		List<Aluno> alunos = ga.getAlunos();
		
		//Adiciona a lista no request como atributo
		
		req.setAttribute("alu", alunos);

		//Levar para o JSP
		RequestDispatcher view = req.getRequestDispatcher("alunos.jsp");
		view.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome =  request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String estado = request.getParameter("estado");
		String sexo = request.getParameter("sexo");
		
		
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setRg(rg);
		aluno.setEstado(estado);
		aluno.setSexo(sexo);
		
		
		GerenciadorAluno ga = new GerenciadorAluno();
		ga.salvar(aluno);
		
		
	}

}