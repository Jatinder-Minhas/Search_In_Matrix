package ca.sheridancollege.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.DataBase.DataBase;
import ca.sheridancollege.DataBase.DataBaseAccess;
import ca.sheridancollege.beans.Login;
import ca.sheridancollege.beans.SearchInMatrix;
import ca.sheridancollege.beans.SquareMatrix;

@Controller
public class HomeController 
{
	@Autowired
	private DataBaseAccess data;
	
	
	@GetMapping("/")
	public String squareMatrix()
	{	
		return "login";
	}
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam String userName, @RequestParam String password)
	{
		Login ln = new Login();
		
		ln.setUserName(userName);
		ln.setPassword(password);
		
		data.addUser(ln);
		
		model.addAttribute("matrix", new SquareMatrix());
		
		return "Home.html";
	}
	
	@GetMapping("/add")
	public String add(Model model, @ModelAttribute SquareMatrix matrix)
	{	
		if(!DataBase.sparse.isEmpty())
		{
			DataBase.sparse.clear();
		}
		
		matrix.fillSquareMatrix();
		DataBase.sparse.add(matrix);
		model.addAttribute("matrix", new SquareMatrix());
		
		return "Home";
	}
	
	@GetMapping("/viewMatrix")
	public String goViewMatrix(Model model)
	{
		
		model.addAttribute("matrixs", DataBase.sparse);
		
		return "ViewMatrix";
	}
	
	@PostMapping("/searchResult")
	public String goSearchResult(Model model, @RequestParam String match)
	{
		DataBase.sparse.get(0).setMatch(match);
		
		SearchInMatrix searchInMatrix = new SearchInMatrix(DataBase.sparse.get(0).getSquareMatrix());

		DataBase.sparse.get(0).setMatchResult(searchInMatrix.search(match));
		
		model.addAttribute("matrixs", DataBase.sparse);
		
		return "result";
	}
	
}
