package com.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.google.gson.Gson;
import com.index.Defaut;
import com.index.Defaut_projet;
import com.index.Scrap;
import com.index.ScrapProjet;
import com.model.ControlInjection;
import com.model.DefautControl;
import com.model.Famille;
import com.model.Piece;
import com.model.Projet;
import com.service.ControlInjectionService;
import com.service.ControleInjectionService;
import com.service.DefautService;
import com.service.FamilleService;
import com.service.PieceService;
import com.service.ProjetService;

import rapport.ScrapParProjet;

@Controller
public class ReportGlobalController {
	
	private ControleInjectionService controleInjectionService;
	private ProjetService projetService;
	private FamilleService familleService;
	private PieceService pieceService;
	private DefautService defautService;
 	
	@Autowired
	public void setFamilleService(FamilleService familleService) {
		this.familleService = familleService;
	}

    @Autowired
	public void setPieceService(PieceService pieceService) {
		this.pieceService = pieceService;
	}


	@Autowired
	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}

	
    @Autowired
	public void setControleInjectionService(ControleInjectionService controleInjectionService) {
		this.controleInjectionService = controleInjectionService;
	}

	
	 @RequestMapping(value="rapport/scrap",method=RequestMethod.GET,produces="text/html")
     public String scrap_get(ModelMap map,HttpServletRequest request) {
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");	
		 map.addAttribute("token",token.getToken());
    	 return "rapport/scrap";
     }
	 
	 @RequestMapping(value="rapport/defauts",method=RequestMethod.GET,produces="text/html")
     public String defauts(ModelMap map,HttpServletRequest request) {
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");	
		 map.addAttribute("token",token.getToken());
    	 return "rapport/defauts";
     }
	 
	 @RequestMapping(value="rapport/projets_par_defaut",method=RequestMethod.GET,produces="text/html")
     public String projets_par_defaut(ModelMap map,HttpServletRequest request) {
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");	
		 map.addAttribute("token",token.getToken());
    	 return "rapport/projets_par_defaut";
     }
	 
	 
	 
	 @RequestMapping(value="rapport/scrap_test",method=RequestMethod.GET,produces="text/html")
     public String scrap_test(ModelMap map,HttpServletRequest request) {
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");	
		 map.addAttribute("token",token.getToken());
    	 return "rapport/scrap_test";
     }
	 
	 
	 @RequestMapping(value="rapport/retouche1",method=RequestMethod.GET,produces="text/html")
     public String retouche1(ModelMap map,HttpServletRequest request) {
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");	
		 map.addAttribute("token",token.getToken());
    	 return "rapport/retouche1";
     }
	
	@RequestMapping(value="rapport/scrap",method=RequestMethod.POST)
	@ResponseBody
    public String scrap_get(@RequestParam("critere")String critere,
    		@RequestParam("date_debut")String date1,
			@RequestParam("date_fin")String date2,
			RedirectAttributes attributes) throws ParseException {
		Date date_debut = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		Date date_fin = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
		List<Scrap> scraps = new ArrayList<>();
		List<Projet> projets = projetService.fetchAll();
		List<Famille> familles = familleService.fetchAll();
		List<Piece> pieces = pieceService.fetchAll();
 		if(critere.equals("projet")) {
 			for (Projet projet2 : projets) {
 				double ok_value = controleInjectionService.getQteByProjet(date_debut,date_fin,"ok",projet2.getTitle());
 				double scrap_value = controleInjectionService.getQteByProjet(date_debut,date_fin,"scrap",projet2.getTitle());
 				System.err.print("projet:"+projet2.getTitle()+"ok:"+ok_value+"scrap:"+scrap_value);
 				if(scrap_value != 0) {
 					Scrap scrap = new Scrap();
 					scrap.setCritere(projet2.getTitle());
 					scrap.setScrap((double)((scrap_value/(scrap_value+ok_value))*100));
 					scraps.add(scrap);
 				
 			}
 			}
 			Collections.sort(scraps);
 			
		}
		if(critere.equals("famille")) {
			for (Famille famille : familles) {
 				double ok_value = controleInjectionService.getQteByFamille(date_debut,date_fin,"ok",famille.getTitle());
 				double scrap_value = controleInjectionService.getQteByFamille(date_debut,date_fin,"scrap",famille.getTitle());
 				if(scrap_value != 0) {
 					Scrap scrap = new Scrap();
 					scrap.setCritere(famille.getTitle());
 					scrap.setScrap((double)((scrap_value/(scrap_value+ok_value))*100));
 					scraps.add(scrap);
 				}
 			}
 			
 			Collections.sort(scraps);
 			
 			
		}
		if(critere.equals("designation")) {
			for (Piece piece : pieces) {
 				double ok_value = controleInjectionService.getQteByVersion(date_debut,date_fin,"ok",piece.getVersion());
 				double scrap_value = controleInjectionService.getQteByVersion(date_debut,date_fin,"scrap",piece.getVersion());
 				if(scrap_value != 0) {
 					Scrap scrap = new Scrap();
 					scrap.setCritere(piece.getVersion());
 					scrap.setScrap((double)((scrap_value/(scrap_value+ok_value))*100));
 					scraps.add(scrap);
 				}
 			}
 			
 			Collections.sort(scraps);
 			
 			
		}
		if(critere.equals("mur")) {
			
		}
	
   	 return new Gson().toJson(scraps);
    }
	
	@RequestMapping(value="rapport/defauts",method=RequestMethod.POST)
	@ResponseBody
	public String defauts(@RequestParam("shift")String shift,
			@RequestParam("equipe")String equipe,
			@RequestParam("zone")String zone,
			@RequestParam("projet")String projet,
			@RequestParam("famille")String famille,
			@RequestParam("version")String version,
			@RequestParam("prototype")String prototype,
			@RequestParam("date_debut")String start,
			@RequestParam("date_fin")String end,
			@RequestParam("type")String type_value) throws ParseException {
		Date date_debut = new SimpleDateFormat("yyyy-MM-dd").parse(start);
		Date date_fin = new SimpleDateFormat("yyyy-MM-dd").parse(end);
		List<Defaut> defauts = new ArrayList<>();
		List<Object> objects = controleInjectionService.getDefautsBy(date_debut, date_fin, zone, shift, equipe, projet, famille, version, prototype,type_value);
		Iterator iterator = objects.iterator();
		while(iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			String type = (String)object[0];
			if(!type.equals("ok")) {
				Defaut defaut = new Defaut();
				defaut.setDefaut((String)object[0]);
				defaut.setQte((int)object[1]);
				defauts.add(defaut);
			}
		}
		Collections.sort(defauts);
        List defaut_detaille = new ArrayList<>();
		for(int i=0;i<4;i++) {
			List<Defaut_projet> defaut_projets2 = new ArrayList<>();
			if(i<defauts.size()) {
				System.err.println(i);
				String defaut_title = defauts.get(i).getDefaut();
				List<Object> objects2 = controleInjectionService.getQteAndProjectsByDefaut(date_debut, date_fin, defaut_title);
				Iterator iterator2 = objects2.iterator();
				while(iterator2.hasNext()) {
					Object[] object2 = (Object[])iterator2.next();
					Defaut_projet defaut_projet = new Defaut_projet();
					defaut_projet.setProjet((String)object2[0]);
					defaut_projet.setQte((int)object2[1]);
					defaut_projets2.add(defaut_projet);
				}
			}
			
			Collections.sort(defaut_projets2);
			defaut_detaille.add(defaut_projets2);
		}
		defaut_detaille.add(defauts);
		return new Gson().toJson(defaut_detaille);
	}
	
	
	@RequestMapping(value="rapport/projets_par_defaut",method=RequestMethod.POST)
	@ResponseBody
	public String defauts_par_projet(
			@RequestParam("defaut")String defaut,
			@RequestParam("date_debut")String start,
			@RequestParam("date_fin")String end) throws ParseException {
		Date date_debut = new SimpleDateFormat("yyyy-MM-dd").parse(start);
		Date date_fin = new SimpleDateFormat("yyyy-MM-dd").parse(end);
		List<Defaut_projet> defaut_projets = new ArrayList<>();
		List<Object> objects = controleInjectionService.getQteAndProjectsByDefaut(date_debut, date_fin, defaut);
		Iterator iterator = objects.iterator();
		while(iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			String type = (String)object[0];
			if(!type.equals("ok")) {
				Defaut_projet defaut_projet = new Defaut_projet();
				defaut_projet.setProjet((String)object[0]);
				defaut_projet.setQte((int)object[1]);
				defaut_projets.add(defaut_projet);
			}
		}
		Collections.sort(defaut_projets);
        
		return new Gson().toJson(defaut_projets);
	}
	
	
	@RequestMapping(value="rapport/scrap_test",method=RequestMethod.POST)
	@ResponseBody
    public String scrap_test(@RequestParam("date_debut")String date1,
    		@RequestParam("date_fin")String date2,
    		RedirectAttributes attributes,
    		HttpServletRequest request) throws ParseException, FileNotFoundException, IOException {
		Map model = new HashMap();
		Date date_debut = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		Date date_fin = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
		//taux de scrap
		List<Projet> projets = projetService.fetchAll();
		List<ScrapParProjet> scrapParProjets = new ArrayList<>();
		for (Projet projet2 : projets) {
				double ok_value = controleInjectionService.getQteByProjet(date_debut,date_fin,"ok",projet2.getTitle());
				double scrap_value = controleInjectionService.getQteByProjet(date_debut,date_fin,"scrap",projet2.getTitle());
				System.err.print("projet:"+projet2.getTitle()+"ok:"+ok_value+"scrap:"+scrap_value);
				if(scrap_value != 0 && scrapParProjets.size() <= 10) {
					ScrapParProjet scrapParProjet = new ScrapParProjet();
					scrapParProjet.setProjet(projet2.getTitle());
					scrapParProjet.setScrap((double)((scrap_value/(scrap_value+ok_value))*100));
						scrapParProjets.add(scrapParProjet);
			    }}
		  /*create excel file*/
		 XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
		 Object[][] datatypes = {
	                {"projet", "scrap"},
	        };
		    for (ScrapParProjet scrapParProjet : scrapParProjets) {
			  	
			}
		    int rowNum = 0;
	        System.out.println("Creating excel");

	        for (Object[] datatype : datatypes) {
	            Row row = sheet.createRow(rowNum++);
	            int colNum = 0;
	            for (Object field : datatype) {
	                Cell cell = row.createCell(colNum++);
	                if (field instanceof String) {
	                    cell.setCellValue((String) field);
	                } else if (field instanceof Integer) {
	                    cell.setCellValue((Integer) field);
	                }
	            }
	        }
		  try {
			    String path = request.getRealPath("/")+"test.xlsx";
	            FileOutputStream outputStream = new FileOutputStream(path);
	            System.err.println(path);
	            workbook.write(outputStream);
	            workbook.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  System.out.println("Done");
          Collections.sort(scrapParProjets);
          System.err.println("context:"+request.getContextPath());
          model.put("scrap_par_projet", scrapParProjets);
         
		 return new Gson().toJson(model);
	}
	
	@RequestMapping(value="rapport/scrap_defaut",method=RequestMethod.POST)
	@ResponseBody
    public String scrap_defaut(@RequestParam("date_debut_defaut")String date1,@RequestParam("date_fin_defaut")String date2,RedirectAttributes attributes) throws ParseException {
		Map model = new HashMap();
		Date date_debut = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		Date date_fin = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
		//top defaut scrap
		List<Defaut> defauts = new ArrayList<>();
		List<Object> objects = controleInjectionService.execute(date_debut,date_fin,"select top 10 code,sum(qte) from ControleInjection where date between :date_debut and :date_fin and type='scrap' group by code");
		Iterator iterator = objects.iterator();
		while(iterator.hasNext()) {
			Object[] objects2 = (Object[])iterator.next();
			Defaut defaut = new Defaut();
			defaut.setDefaut(defautService.getDefautByCode((String)objects2[0]).getTitle());
			defaut.setQte((int)objects2[1]);
			defauts.add(defaut);
		}
         Collections.sort(defauts);
         model.put("top_defaut", defauts);
		 return new Gson().toJson(model);
	}
	
	
	@RequestMapping(value="rapport/scrap_defaut_projet",method=RequestMethod.POST)
	@ResponseBody
    public String scrap_defau_projet(@RequestParam("date_debut_defaut")String date1,@RequestParam("date_fin_defaut")String date2,RedirectAttributes attributes,@RequestParam("projet")String projet) throws ParseException {
		Map model = new HashMap();
		Date date_debut = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		Date date_fin = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
		//top defaut scrap
		List<Defaut> defauts = new ArrayList<>();
		List<Object> objects = controleInjectionService.execute(date_debut,date_fin,"select top 10 code,sum(qte) from ControleInjection where date between :date_debut and :date_fin and type='scrap' and projet='"+projet+"' group by code");
		Iterator iterator = objects.iterator();
		while(iterator.hasNext()) {
			Object[] objects2 = (Object[])iterator.next();
			Defaut defaut = new Defaut();
			defaut.setDefaut(defautService.getDefautByCode((String)objects2[0]).getTitle());
			defaut.setQte((int)objects2[1]);
			defauts.add(defaut);
		}
         Collections.sort(defauts);
         model.put("top_defaut", defauts);
		 return new Gson().toJson(model);
	}
	
	
	@RequestMapping(value="rapport/scrap_projet_defaut",method=RequestMethod.POST)
	@ResponseBody
    public String scrap_projet_defaut(@RequestParam("date_debut_projet_defaut")String date1,@RequestParam("date_fin_projet_defaut")String date2,RedirectAttributes attributes,@RequestParam("defaut")String defaut) throws ParseException {
		Map model = new HashMap();
		Date date_debut = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		Date date_fin = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
		//top defaut scrap
		List<Defaut_projet> defaut_projets = new ArrayList<>();
		System.err.println(defaut);
		if( defautService.getDefautByTitle(defaut) != null) {
			String code = defautService.getDefautByTitle(defaut).getCode();
		
			List<Object> objects = controleInjectionService.execute(date_debut,date_fin,"select top 10 projet,sum(qte) from ControleInjection where date between :date_debut and :date_fin and type='scrap' and code='"+code+"' group by projet");
			Iterator iterator = objects.iterator();
			while(iterator.hasNext()) {
				Object[] objects2 = (Object[])iterator.next();
				Defaut_projet defaut_projet = new Defaut_projet();
				defaut_projet.setProjet((String)objects2[0]);//
				defaut_projet.setQte((int)objects2[1]);
				defaut_projets.add(defaut_projet);
			}
	         Collections.sort(defaut_projets);
	         model.put("top_projets", defaut_projets);
			
		}
		 return new Gson().toJson(model);
	}


	@Autowired
	public void setDefautService(DefautService defautService) {
		this.defautService = defautService;
	}
	
}
