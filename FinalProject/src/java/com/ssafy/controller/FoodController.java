package com.ssafy.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ssafy.model.dto.Food;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.TotalList;
import com.ssafy.model.service.FoodService;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.TotalListService;
import com.ssafy.util.KMP;

@Controller
public class FoodController {
	@Autowired
	private FoodService service;
	@Autowired
	private MemberService m_service;
	@Autowired
	private TotalListService t_service;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date d = new Date();

//	@ExceptionHandler
//	public ModelAndView handler(Exception e) {
//		ModelAndView mav = new ModelAndView("ErrorHandler.jsp");
//		mav.addObject("msg", e.getMessage());
//		return mav;
//	}

	@GetMapping("")
	public String getMains(String key, String word, String pageNo, Model model) {
		PageBean bean = new PageBean(key, word, pageNo);
		model.addAttribute("list", service.searchAll(bean));
		model.addAttribute("bean", bean);

		return "Main";
	}

	@GetMapping("main.do")
	public String getMain(String key, String word, String pageNo, Model model) {
//		String key = request.getParameter("key");		//조회 조건
//		String word = request.getParameter("word");		//검색할 단어
//		String pageNo = request.getParameter("pageNo");	//현재 페이지 번호
//		
		PageBean bean = new PageBean(key, word, pageNo);
		model.addAttribute("list", service.searchAll(bean));
		model.addAttribute("bean", bean);

		return "Main";
	}

	@GetMapping("foodlist.do")
	public String getFoodList(String key, String word, String pageNo, Model model) throws SQLException {
		PageBean bean = new PageBean(key, word, pageNo);
		model.addAttribute("bean", bean);
		model.addAttribute("list", service.searchAll(bean));
		List<Integer> code = service.nondomeSearch();
		List<Food> dome = new LinkedList<Food>();
		for (int c : code) {
			dome.add(service.search("code", String.valueOf(c)));
		}
		model.addAttribute("dome", dome);
		return "foodlist";
	}

	@GetMapping("foodInfo.do")
	public String getFoodInfo(Model model, String name, HttpSession session) {
		System.out.println(name);
		Food food = service.search("name", name);
		model.addAttribute("f", food);
		String userid = (String) session.getAttribute("id");
		System.out.println(userid);
		if (userid != null) {
			Member member = m_service.search(userid);
			if (member.getMaterial() != null) {
				String[] allergys = member.getMaterial().split(",");
				System.out.println(Arrays.toString(allergys));
				model.addAttribute("aler", service.alerSearch(food.getMaterial(), allergys));
			}
		} else {
			model.addAttribute("aler", "");
		}
		return "detailInfo";
	}

	@GetMapping("search.do")
	public String search(String sel1, String keyword, String pageNo, Model model) {
		PageBean bean = new PageBean(sel1, keyword, pageNo);
		model.addAttribute("bean", bean);
		System.out.println(sel1 + "  " + keyword);
		model.addAttribute("list", service.searchAll(bean));
		System.out.println(service.searchAll(bean));

		return "foodlist";
	}

	@PostMapping("sort.do")
	public String sort(String sort, String type, String key, String word, String pageNo, Model model) {
		PageBean bean = new PageBean(key, word, pageNo);
		model.addAttribute("bean", bean);
		List<Food> food = service.searchAll(bean);
		switch (sort) {
		case "no":

			break;
		case "name":
			Collections.sort(food, new Comparator<Food>() {
				@Override
				public int compare(Food o1, Food o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			break;
		case "kal":
			Collections.sort(food, new Comparator<Food>() {
				@Override
				public int compare(Food o1, Food o2) {
					return o1.getNutr_cont1().compareTo(o2.getNutr_cont1());
				}
			});
			break;
		default:
			break;
		}
		if (type.equals("내림차순")) {
			System.out.println("!!");
			Collections.reverse(food);
		}
		model.addAttribute("list", food);
		return "Main";
	}

	@GetMapping("filter.do")
	public String filter(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("id");
		Member mem = m_service.search(userID);
		System.out.println(mem);
		String material = mem.getMaterial();
		String[] mat = material.split(",");
		List<Food> result = new LinkedList<Food>();

		String key = request.getParameter("key"); // 조회 조건
		String word = request.getParameter("word"); // 검색할 단어
		String pageNo = request.getParameter("pageNo"); // 현재 페이지 번호

		PageBean bean = new PageBean(key, word, pageNo);
		request.setAttribute("bean", bean);
		List<Food> food = service.searchAll(bean);

		for (int i = 0, size = food.size(); i < size; i++) {
			String input = food.get(i).getMaterial() + food.get(i).getName();
			if (!KMP.KMPSearch(input, mat)) {
				result.add(food.get(i));
			}
		}
		request.setAttribute("list", result);
		return "Main";
	}

	@GetMapping("qna.do")
	public String qnaMain() {
		return "redirect:index.html";
	}

	@GetMapping("addcart.do")
	public String addCart(HttpServletRequest request) {
		HttpSession session = request.getSession();

		return "redirect:cart.do";
	}

	@GetMapping("cart.do")
	public String cartMain(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		PageBean bean = new PageBean("A02", (String) session.getAttribute("id"), 1);
		model.addAttribute("bean", bean);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		
		TotalList totallist = new TotalList("A02"
				, (String)session.getAttribute("id")
				, format.format(d), request.getParameter("code"), 1);
		
		if(t_service.isUnique(totallist) == null && request.getParameter("code") != null) {
			
			t_service.addList(totallist);
		} else if(request.getParameter("code") != null){
			totallist = t_service.isUnique(totallist);
			int count = totallist.getCount();
			totallist.setCount(count+1);
			t_service.updateList(totallist);
		}

		List<TotalList> carts = t_service.searchByCondition(bean);
		System.out.println("---------------------- 카트 사이즈 " + carts.size());
		
		
		List<Food> result = new LinkedList<Food>();
		
		List<Food> food = service.searchAll(bean);
		
		for (TotalList cart : carts) {
			if(cart.getDate().equals(format.format(d))) {
				result.add(food.get(Integer.parseInt(cart.getList()) - 1));
			}
		}
		
		model.addAttribute("list", result);
		
		return "cart";
	}
	
	@GetMapping("cartchart.do")
	@ResponseBody
	public String cartChart(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("id");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		
		if (userid == null) {
			System.out.println("로그인 먼저 하세요!");
			model.addAttribute("msg", "로그인을 해주세요!");
			return "Main";
		} else {
			PageBean bean = new PageBean("A01", userid, "1");
			PageBean bean2 = new PageBean("A02", userid, 2);
			List<TotalList> list = t_service.searchByCondition(bean);
			List<TotalList> list2 = t_service.searchByCondition(bean2);
			double serving_wt = 0;
			double nutr_cont1 = 0;
			double nutr_cont2 = 0;
			double nutr_cont3 = 0;
			double nutr_cont4 = 0;
			double nutr_cont5 = 0;
			double nutr_cont6 = 0;
			double nutr_cont7 = 0;
			double nutr_cont8 = 0;
			double nutr_cont9 = 0;
			for (TotalList total : list) {
				Food food = service.search("code", total.getList());
				System.out.println(food);
				serving_wt += Double.parseDouble(!food.getServing_wt().equals("N/A") ? food.getServing_wt() : "0.0");
				nutr_cont1 += Double.parseDouble(!food.getNutr_cont1().equals("N/A") ? food.getNutr_cont1() : "0.0");
				nutr_cont2 += Double.parseDouble(!food.getNutr_cont2().equals("N/A") ? food.getNutr_cont2() : "0.0");
				nutr_cont3 += Double.parseDouble(!food.getNutr_cont3().equals("N/A") ? food.getNutr_cont3() : "0.0");
				nutr_cont4 += Double.parseDouble(!food.getNutr_cont4().equals("N/A") ? food.getNutr_cont4() : "0.0");
				nutr_cont5 += Double.parseDouble(!food.getNutr_cont5().equals("N/A") ? food.getNutr_cont5() : "0.0");
				nutr_cont6 += Double.parseDouble(!food.getNutr_cont6().equals("N/A") ? food.getNutr_cont6() : "0.0");
				nutr_cont7 += Double.parseDouble(!food.getNutr_cont7().equals("N/A") ? food.getNutr_cont7() : "0.0");
				nutr_cont8 += Double.parseDouble(!food.getNutr_cont8().equals("N/A") ? food.getNutr_cont8() : "0.0");
				nutr_cont9 += Double.parseDouble(!food.getNutr_cont9().equals("N/A") ? food.getNutr_cont9() : "0.0");
			}
			
			for (TotalList total : list2) {
				if(!total.getDate().equals(format.format(d))) continue;
				Food food = service.search("code", total.getList());
				System.out.println(food);
				serving_wt += Double.parseDouble(!food.getServing_wt().equals("N/A") ? food.getServing_wt() : "0.0");
				nutr_cont1 += Double.parseDouble(!food.getNutr_cont1().equals("N/A") ? food.getNutr_cont1() : "0.0");
				nutr_cont2 += Double.parseDouble(!food.getNutr_cont2().equals("N/A") ? food.getNutr_cont2() : "0.0");
				nutr_cont3 += Double.parseDouble(!food.getNutr_cont3().equals("N/A") ? food.getNutr_cont3() : "0.0");
				nutr_cont4 += Double.parseDouble(!food.getNutr_cont4().equals("N/A") ? food.getNutr_cont4() : "0.0");
				nutr_cont5 += Double.parseDouble(!food.getNutr_cont5().equals("N/A") ? food.getNutr_cont5() : "0.0");
				nutr_cont6 += Double.parseDouble(!food.getNutr_cont6().equals("N/A") ? food.getNutr_cont6() : "0.0");
				nutr_cont7 += Double.parseDouble(!food.getNutr_cont7().equals("N/A") ? food.getNutr_cont7() : "0.0");
				nutr_cont8 += Double.parseDouble(!food.getNutr_cont8().equals("N/A") ? food.getNutr_cont8() : "0.0");
				nutr_cont9 += Double.parseDouble(!food.getNutr_cont9().equals("N/A") ? food.getNutr_cont9() : "0.0");
			}
			
			Food f = new Food(String.valueOf(String.format("%.2f", serving_wt)),
					String.valueOf(String.format("%.2f", nutr_cont1)),
					String.valueOf(String.format("%.2f", nutr_cont2)),
					String.valueOf(String.format("%.2f", nutr_cont3)),
					String.valueOf(String.format("%.2f", nutr_cont4)),
					String.valueOf(String.format("%.2f", nutr_cont5)),
					String.valueOf(String.format("%.2f", nutr_cont6)),
					String.valueOf(String.format("%.2f", nutr_cont7)),
					String.valueOf(String.format("%.2f", nutr_cont8)),
					String.valueOf(String.format("%.2f", nutr_cont9)));
			System.out.println(f);
			Gson gson = new Gson();
			return gson.toJson(f);
		}
	}
	@GetMapping("updateCart.do")
	public String updateCart(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		PageBean bean = new PageBean("A02", (String) session.getAttribute("id"), 1);
		model.addAttribute("bean", bean);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String foodCode = request.getParameter("code");
		
		System.out.println(foodCode);
		
		TotalList totallist = new TotalList("A02"
				, (String)session.getAttribute("id")
				, format.format(d), foodCode, 1);
		
		TotalList ans = t_service.isUnique(totallist);
		
		System.out.println(ans);
		t_service.deleteList(ans.getNo());
		return "redirect:cart.do";
		
	}
	
	@GetMapping("bestfood.do")
	public String bestFood(Model model, HttpServletRequest request) {
		System.out.println("bestFood들어옴");
		List<Integer> bestList = t_service.bestfood();
		PageBean bean = new PageBean();
		List<Food> foodList = service.searchAll(bean);
		
		List<Food> ans = new LinkedList<Food>();
		for(int i = 0; i < bestList.size(); i++) {
			ans.add(foodList.get(bestList.get(i)));
		}
		
		model.addAttribute("list", ans);
		model.addAttribute("cnt", 0);
		System.out.println();
		return "bestfood";
	}

	@GetMapping("takechart.do")
	@ResponseBody
	public String takeChart(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			System.out.println("로그인 먼저 하세요!");
			model.addAttribute("msg", "로그인을 해주세요!");
			return "Main";
		} else {
			PageBean bean = new PageBean("A01", userid, "1");
			List<TotalList> list = t_service.searchByCondition(bean);
			double serving_wt = 0;
			double nutr_cont1 = 0;
			double nutr_cont2 = 0;
			double nutr_cont3 = 0;
			double nutr_cont4 = 0;
			double nutr_cont5 = 0;
			double nutr_cont6 = 0;
			double nutr_cont7 = 0;
			double nutr_cont8 = 0;
			double nutr_cont9 = 0;
			for (TotalList total : list) {
				Food food = service.search("code", total.getList());
				System.out.println(food);
				serving_wt += Double.parseDouble(!food.getServing_wt().equals("N/A") ? food.getServing_wt() : "0.0");
				nutr_cont1 += Double.parseDouble(!food.getNutr_cont1().equals("N/A") ? food.getNutr_cont1() : "0.0");
				nutr_cont2 += Double.parseDouble(!food.getNutr_cont2().equals("N/A") ? food.getNutr_cont2() : "0.0");
				nutr_cont3 += Double.parseDouble(!food.getNutr_cont3().equals("N/A") ? food.getNutr_cont3() : "0.0");
				nutr_cont4 += Double.parseDouble(!food.getNutr_cont4().equals("N/A") ? food.getNutr_cont4() : "0.0");
				nutr_cont5 += Double.parseDouble(!food.getNutr_cont5().equals("N/A") ? food.getNutr_cont5() : "0.0");
				nutr_cont6 += Double.parseDouble(!food.getNutr_cont6().equals("N/A") ? food.getNutr_cont6() : "0.0");
				nutr_cont7 += Double.parseDouble(!food.getNutr_cont7().equals("N/A") ? food.getNutr_cont7() : "0.0");
				nutr_cont8 += Double.parseDouble(!food.getNutr_cont8().equals("N/A") ? food.getNutr_cont8() : "0.0");
				nutr_cont9 += Double.parseDouble(!food.getNutr_cont9().equals("N/A") ? food.getNutr_cont9() : "0.0");
			}
			
			Food f = new Food(String.valueOf(String.format("%.2f", serving_wt)),
					String.valueOf(String.format("%.2f", nutr_cont1)),
					String.valueOf(String.format("%.2f", nutr_cont2)),
					String.valueOf(String.format("%.2f", nutr_cont3)),
					String.valueOf(String.format("%.2f", nutr_cont4)),
					String.valueOf(String.format("%.2f", nutr_cont5)),
					String.valueOf(String.format("%.2f", nutr_cont6)),
					String.valueOf(String.format("%.2f", nutr_cont7)),
					String.valueOf(String.format("%.2f", nutr_cont8)),
					String.valueOf(String.format("%.2f", nutr_cont9)));
			System.out.println(f);
			Gson gson = new Gson();
			return gson.toJson(f);
		}
	}

	@GetMapping("takeList.do")
	public String takeList(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			System.out.println("로그인 먼저 하세요!");
			model.addAttribute("msg", "로그인을 해주세요!");
			return "Main";
		} else {
			PageBean bean = new PageBean("A01", userid, "1");
			List<TotalList> list = t_service.searchByCondition(bean);
			List<TotalList> lists = new LinkedList<>();
			for (TotalList total : list) {
				TotalList food = new TotalList(total.getNo(), "A01", userid, total.getDate(), total.getList(),
						total.getCount());
				TotalList totallist = t_service.foodsearch(food);
				lists.add(totallist);
			}
			model.addAttribute("list", lists);
			return "takeFood";
		}
	}

	@GetMapping("takeFood.do")
	public String takeFood(String code, Model model, String date, int eat_cnt, HttpSession session) {
		String userid = (String) session.getAttribute("id");
		System.out.println(code);
		if (userid == null) {
			System.out.println("로그인 먼저 하세요!");
			model.addAttribute("msg", "로그인을 해주세요!");
			return "Main";
		} else {
			TotalList food = new TotalList("A01", userid, date, code, eat_cnt);
			t_service.addList(food);
			System.out.println("추가");
		}
		return "redirect:foodlist.do";
	}

	@GetMapping("maintakeFood.do")
	public String maintakeFood(String code, String date, int eat_cnt, Model model, HttpSession session) {
		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			System.out.println("로그인 먼저 하세요!");
			model.addAttribute("msg", "로그인을 해주세요!");
			return "Main";
		} else {
			TotalList food = new TotalList("A01", userid, date, code, eat_cnt);
			t_service.addList(food);
			System.out.println("추가");
		}
		return "redirect:main.do";
	}

	@GetMapping("takeout.do")
	public String takeOut(int no, Model model, HttpSession session) {
		t_service.deleteList(no);
		return "redirect:takeList.do";
	}

//	@GetMapping("takeout.do")
//	public String takeOut(String code, Model model, HttpSession session) {
//		String userid = (String) session.getAttribute("id");
//		String s = null;
//		TotalList food = new TotalList("A01", userid, format.format(d), code, 1);
//		TotalList uniq = t_service.isUnique(food);
//		s = uniq.getList();
//		String ss[] = s.split(",");
//		for (int i = 0; i < ss.length; ++i) {
//			if (ss[i].equals(code)) {
//				ss[i] = " ";
//				break;
//			}
//		}
//		String ns = "";
//		String ns2 = "";
//		for (int i = 0; i < ss.length; ++i) {
//			if (!ss[i].equals(" ")) {
//				ns += ss[i] + ",";
//			}
//		}
//		if (ns.endsWith(",")) {
//			ns2 = ns.substring(0, ns.length() - 1);
//		}
//		TotalList newlist = new TotalList(uniq.getNo(), "A01", userid, uniq.getDate(), ns2, 1);
//		t_service.updateList(newlist);
//		
//		return "redirect:takeList.do";
//	}

}