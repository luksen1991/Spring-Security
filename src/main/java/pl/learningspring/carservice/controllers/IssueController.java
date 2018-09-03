package pl.learningspring.carservice.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.learningspring.carservice.dto.Issue;
import pl.learningspring.carservice.repository.IssuesRepository;

@Controller
public class IssueController {
	
	private IssuesRepository issueRepository;
	
	@Autowired
	public IssueController(IssuesRepository issueRepository) {
		super();
		this.issueRepository = issueRepository;
	}


	@PostMapping("/addissue")
	public String addIssue(@ModelAttribute Issue issue) {
		issueRepository.addIssue(issue);
		return "confirm";
	}
	
	@PostMapping("/approve")
	public String approveIssue(@RequestParam Long id, @RequestParam(defaultValue="false") Boolean approved, Model model) {
		List<Issue> issues=issueRepository.upadateApprove(id,approved);
		model.addAttribute("issues", issues);
		return "issues";
	}
	
	
	@GetMapping("/issue/{id}")
	public String getIssue(@PathVariable Long id, Model model) {
		Issue issue = issueRepository.getIssue(id);
		model.addAttribute("issue", issue);
		return "confirm";
		
	}
	
	@GetMapping("/issues")
	public String getIssueList(Model model) {
		List<Issue> issues = issueRepository.getAllIssue();
		model.addAttribute("issues", issues);
		return "issues";	
		
	}
	
	@GetMapping({"/","/index", "/index.html"})
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.getRemoteUser());
		return "index";	
		
	}
	
	@GetMapping({"/issue"})
	public String issue(Model model) {
		return "issue";	
		
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "mylogin";
	}
}
