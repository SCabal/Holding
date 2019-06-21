package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import Model.Cubicle;
import Model.Education;
import Model.Employee;
import Model.Poll;
import Model.Fabrication;
import Model.Holding;
import Model.MedFabrication;
import Model.PublicServices;
import Model.Technology;
import Model.PublicServiceType;
import Model.OrgType;


public class Main {

	private Holding principal;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public Main() {
		Date consDate=new Date();
		consDate.setDate(28);
		consDate.setMonth(8);
		consDate.setYear(1898);
		String name="PepsiCo Inc";
		String nit="890920304";
		String dirCorrespon="Cl-110 #9-25(BOGOTA)";
		String tel="13819443";
		int employeeCuant=263000;
		int actPesos=414058000;
		OrgType type=OrgType.ComerciMayorMenor;
		String legalRepreName= "Eduardo";
		Cubicle[][][] building=new Cubicle[7][7][7];
		principal =new Holding(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate, legalRepreName, building);
		
	}
	private void ejecut() throws Exception {
		boolean opened = true;
		while (opened) {
			opened = openMenu();
		}
		System.out.println("Hasta pronto");
		br.close();
	}
	private boolean openMenu() throws Exception {
		System.out.println("Bienbenido al servicio de Holding de la empresa: " + principal.toString());
		System.out.println("//////////////////////////////////////////////////////////");
		System.out.println("Ingresa un numero para acceder:");
		System.out.println("1. Registrar Empresa a Holding");
		System.out.println("2. Mostrar informacion de las empresas");
		System.out.println("3. Valorar empresa (Test)");
		System.out.println("4. Buscar Employee por name");
		System.out.println("5. Buscar eMails por charge");
		System.out.println("6. Agregar Employee");
		System.out.println("7. Salir");

		int select = Integer.parseInt(br.readLine());
		return startMethod(select);
	}
	private boolean startMethod(int select) throws Exception {
		boolean ope=false;
		boolean flag=true;
		if(select==1) {
			ope=register();
		}else if(select==2) {
			ope=showInfo();
		}else if(select==3) {
			ope=rateOrg();
		}else if(select==4) {
			ope=searchEmployee();
		}
		else if(select==5) {
			ope=searchMail();
		}
		else if(select==6) {
			ope=addEmployee();
		}else {
			ope=true;
			flag=false;
		}
		
		if(ope) {
			System.out.println("Operacion exitosa");
		}else {
			System.out.println("Operacion fallada");
		}
		return flag;
	}
	private boolean addEmployee() throws Exception {
		System.out.println("Ingrese 1 para seleccionar empresas de Fabrication");
		System.out.println("Ingrese 2 para seleccionar empresas de servicios");
		int select = Integer.parseInt(br.readLine());
		if(select==1) {
			System.out.println("Ingrese 1 para seleccionar empresas de Servicios Publicos");
			System.out.println("Ingrese 2 para seleccionar empresas de Education");
			System.out.println("Ingrese 3 para seleccionar empresas de Technology");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				System.out.println("Seleccione con un numero la empresa ");
				ArrayList<PublicServices> objectList=principal.getPublicServices();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					PublicServices aux=objectList.get(select-1);
					
					aux.addEmployee("Eduardo", "Maquinista", "Eduardo@Corre.empresa.co");
					
					return true;
				}
				
			}else if(select==2) {
				
				ArrayList<Education> objectList=principal.getEducation();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					Education aux=objectList.get(select-1);
					
					aux.addEmployee("Santiago", "Marica", "Santiago@icesi.gel.net");
					
					return true;
				}
			}else if(select==3) {
				
				ArrayList<Technology> objectList=principal.getTechnology();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					Technology aux=objectList.get(select-1);
					
					aux.addEmployee("Litos", "Marihuanero", "falson.falsetin@marihualitos.net");
					
					return true;
				}
			}
		}else {
			System.out.println("Ingrese 1 para seleccionar empresas de Fabrication(Normal)");
			System.out.println("Ingrese 2 para seleccionar empresas de Fabrication(Medicamento)");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				
				ArrayList<Fabrication> objectList=principal.getFabricationOrg();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					Fabrication aux=objectList.get(select-1);
					
					aux.addEmployee("Ovejo", "Barrendero", "ovejo.Sistemas.pokemon@outlook.co");
					
					return true;
				}
			}else if(select==2) {
				
				ArrayList<MedFabrication> objectList=principal.getMedFabrication();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					MedFabrication aux=objectList.get(select-1);
				
					aux.addEmployee("Manuela", "Secretaria", "manutov.reggaeton@gmail.com");
					
					return true;
				}
			}
		}
		return false;
	}
	private boolean searchMail() throws Exception {
		System.out.println("Escriba el cargo");
		String charge=br.readLine();
		System.out.println("Ingrese 1 para buscar en empresas de Fabricacion");
		System.out.println("Ingrese 2 para buscar en empresas de servicios");
		int select = Integer.parseInt(br.readLine());
		if(select==1) {
			System.out.println("Ingrese 1 para buscar en empresas de Servicios Publicos");
			System.out.println("Ingrese 2 para buscar en empresas de Educacion");
			System.out.println("Ingrese 3 para buscar en empresas de Tecnologia");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				System.out.println("Selecciones con un numero la empresa a seleccionar");
				ArrayList<PublicServices> objectList=principal.getServiciosPublicos();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					ArrayList<String> eMails=objectList.get(select-1).searchMailbyCharge(charge);
					if(eMails!=null) {
						System.out.println("El correo del cargo "+charge+", es:");
						for (int i = 0; i < eMails.size(); i++) {							
						System.out.println(eMails.get(i));
						}
					}else {
						System.out.println("No se encontro el empleado");
					}
					return true;
				}
				
			}else if(select==2) {
			
				ArrayList<Education> objectList=principal.getEducation();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					ArrayList<String> eMails=objectList.get(select-1).searchMailbyCharge(charge);
					if(eMails!=null) {
						System.out.println("El correo del cargo "+charge+", es:");
						for (int i = 0; i < eMails.size(); i++) {							
						System.out.println(eMails.get(i));
						}
					}else {
						System.out.println("No se encontro el empleado");
					}
					return true;
				}
			}else if(select==3) {
				
				ArrayList<Technology> objectList=principal.getTechnology();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					ArrayList<String> eMails=objectList.get(select-1).searchMailbyCharge(charge);
					if(eMails!=null) {
						System.out.println("El correo del cargo "+charge+", es:");
						for (int i = 0; i < eMails.size(); i++) {							
						System.out.println(eMails.get(i));
						}
					}else {
						System.out.println("No se encontro el empleado");
					}
					return true;
				}
				
			}
		}else {
			System.out.println("Ingrese 1 para buscar en empresas de Fabrication(Normal)");
			System.out.println("Ingrese 2 para buscar en empresas de Fabrication(Medicamento)");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				
				ArrayList<Fabrication> objectList=principal.getFabricationOrg();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					ArrayList<String> eMails=objectList.get(select-1).searchMailbyCharge(charge);
					if(eMails!=null) {
						System.out.println("El correo del cargo "+charge+", es:");
						for (int i = 0; i < eMails.size(); i++) {							
						System.out.println(eMails.get(i));
						}
					}else {
						System.out.println("No se encontro el empleado");
					}
					return true;
				}
			}else if(select==2) {
				
				ArrayList<MedFabrication> objectList=principal.getMedFabrication();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					ArrayList<String> eMails=objectList.get(select-1).searchMailbyCharge(charge);
					if(eMails!=null) {
						System.out.println("El correo del cargo "+charge+", es:");
						for (int i = 0; i < eMails.size(); i++) {							
						System.out.println(eMails.get(i));
						}
					}else {
						System.out.println("No se encontro el empleado");
					}
					return true;
				}
			}
		}
		return false;
	}
	private boolean searchEmployee() throws Exception {
		System.out.println("Ingrese la letra segun la busqueda que quiera hacer");
		System.out.println("Letra L: busca en los primeros cubículos de todos los pisos, junto con los cubículos del primer piso de la matriz.\n" + 
				"Letra Z: busca en los cubículos del primer y último piso, junto con los cubículos de la diagonal inversa.\n" + 
				"Letra X: busca en los cubículos ubicados en la diagonal principal y la diagonal inversa.\n" + 
				"Letra O: busca en los cubículos del primer y último piso, junto con los cubículos ubicados en las ventanas del building (primero y último de cada piso).\n" + 
				"Letra E: busca en todos los cubículos del building pero en espiral por fila. Este tipo de recorrido solo se puede realizar si la cantidad de pisos del building es impar.");
		
		String letra=br.readLine();
		if(!letra.equals("L")||!letra.equals("Z")||!letra.equals("X")||!letra.equals("O")||!letra.equals("E"))
			return false;
		System.out.println("Ingrese el nombre a buscar");
		String name=br.readLine();
		System.out.println("Ingrese 1 para buscar en empresas de Fabricacion");
		System.out.println("Ingrese 2 para buscar en empresas de servicios");
		int select = Integer.parseInt(br.readLine());
		if(select==1) {
			System.out.println("Ingrese 1 para buscar en empresas de Servicios Publicos");
			System.out.println("Ingrese 2 para buscar en empresas de Educacion");
			System.out.println("Ingrese 3 para buscar en empresas de Tecnologia");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				System.out.println("Selecciones con un numero la empresa a seleccionar");
				ArrayList<PublicServices> objectList=principal.getServiciosPublicos();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					
					String extention=objectList.get(select-1).findExtentionByNameAndFunction(letra,name);
					if(extention!=null) {						
						System.out.println("La extention de "+name+", es: "+ extention);
					}else {
						System.out.println("No se encontro el Empleado");
					}
					return true;
				}
				
			}else if(select==2) {
				
				ArrayList<Education> objectList=principal.getEducation();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					
					String extention=objectList.get(select-1).findExtentionByNameAndFunction(letra,name);
					if(extention!=null) {						
						System.out.println("La extention de "+name+", es: "+ extention);
					}else {
						System.out.println("No se encontro el Empleado");
					}
					return true;
				}
				
			}else if(select==3) {
			
				ArrayList<Technology> objectList=principal.getTechnology();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					
					String extention=objectList.get(select-1).findExtentionByNameAndFunction(letra,name);
					if(extention!=null) {						
						System.out.println("La extention de "+name+", es: "+ extention);
					}else {
						System.out.println("No se encontro el Empleado");
					}
					return true;
				}
				
				
			}
		}else {
			System.out.println("Ingrese 1 para buscar en empresas de Fabricacion(Normal)");
			System.out.println("Ingrese 2 para buscar en empresas de Fabricacion(Medicamento)");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				
				ArrayList<Fabrication> objectList=principal.getFabricationOrg();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					
					String extention=objectList.get(select-1).findExtentionByNameAndFunction(letra,name);
					if(extention!=null) {						
						System.out.println("La extention de "+name+", es: "+ extention);
					}else {
						System.out.println("No se encontro el Empleado");
					}
					return true;
				}
			}else if(select==2) {
				
				ArrayList<MedFabrication> objectList=principal.getMedFabrication();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					
					String extention=objectList.get(select-1).findExtentionByNameAndFunction(letra,name);
					if(extention!=null) {						
						System.out.println("La extention de "+name+", es: "+ extention);
					}else {
						System.out.println("No se encontro el Empleado");
					}
					return true;
				}
			}
		}
		return false;
	}
	private boolean rateOrg() throws Exception {
		
		
			System.out.println("Ingrese 1 para valoracion de Servicios Publicos");
			System.out.println("Ingrese 2 para valoracion de Education");
			System.out.println("Ingrese 3 para valoracion de Technology");
			int select = Integer.parseInt(br.readLine());
			if(select==1) {
				System.out.println("Selecciones con un numero la empresa a valorar");
				ArrayList<PublicServices> objectList=principal.getServiciosPublicos();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					PublicServices i=objectList.get(select-1);
					System.out.println("Del 1 al 5 conteste.");
					System.out.println("El servicio prestado");
					int one=Integer.parseInt(br.readLine());
					System.out.println("El tiempo de respuestaDado");
					int two=Integer.parseInt(br.readLine());
					System.out.println("La relacion costo/beneficio del servicio adquirido");
					int tree=Integer.parseInt(br.readLine());
					if(one<1&&one>5)
						return false;
					if(two<1&&two>5)
						return false;
					if(tree<1&&tree>5)
						return false;
					Poll newis=new Poll(one, two, tree);
					i.addPoll(newis);
					return true;
				}
				
			}else if(select==2) {
			
				ArrayList<Education> objectList=principal.getEducation();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					Education i=objectList.get(select-1);
					System.out.println("Del 1 al 5 conteste.");
					System.out.println("El servicio prestado");
					int one=Integer.parseInt(br.readLine());
					System.out.println("El tiempo de respuesta Dado");
					int two=Integer.parseInt(br.readLine());
					System.out.println("La relacion costo/beneficio del servicio adquirido");
					int tree=Integer.parseInt(br.readLine());
					if(one<1&&one>5)
						return false;
					if(two<1&&two>5)
						return false;
					if(tree<1&&tree>5)
						return false;
					Poll newis=new Poll(one, two, tree);
					i.addPoll(newis);
					return true;
				}
				
			}else if(select==3) {
			
				ArrayList<Technology> objectList=principal.getTechnology();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					Technology i=objectList.get(select-1);
					System.out.println("Del 1 al 5 conteste.");
					System.out.println("El servicio prestado");
					int one=Integer.parseInt(br.readLine());
					System.out.println("El tiempo de respuestaDado");
					int two=Integer.parseInt(br.readLine());
					System.out.println("La relacion costo/beneficio del servicio adquirido");
					int tree=Integer.parseInt(br.readLine());
					if(one<1&&one>5)
						return false;
					if(two<1&&two>5)
						return false;
					if(tree<1&&tree>5)
						return false;
					Poll newis=new Poll(one, two, tree);
					i.addPoll(newis);
					return true;
				}
			}
		return false;
	}
	private boolean showInfo() throws Exception {
		
		System.out.println("Ingrese 1 para mostrar info de empresas de Fabrication");
		System.out.println("Ingrese 2 para mostrar info de empresas de servicios");
		int select = Integer.parseInt(br.readLine());
		if(select==1) {
			System.out.println("Ingrese 1 para mostrar info de empresas de Servicios Publicos");
			System.out.println("Ingrese 2 para mostrar info de empresas de Education");
			System.out.println("Ingrese 3 para mostrar info de empresas de Technology");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				System.out.println("Selecciones con un numero la empresa a mostrar");
				ArrayList<PublicServices> objectList=principal.getServiciosPublicos();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					PublicServices i=objectList.get(select-1);
					System.out.println("name: "+i.getName());
					System.out.println("Nit: "+i.getNit());
					System.out.println("Direccion correspondiente: "+i.getDirCorrespon());
					System.out.println("Telefono: "+i.getTel());
					System.out.println("# Empleados: "+i.getEmployeeCuant());
					System.out.println("Valor actPesos pesos: "+i.getActPesos());
					System.out.println("Fecha Constitucion: "+i.getConsDate().toString());
					System.out.println("Nombre del representante legal: "+i.getLegalRepreName());
					System.out.println("Suscriptores Totales: "+i.getTotalSubs());
					System.out.println("Suscriptores estrato 1 y 2: "+i.getStratum1and2Subs());
					System.out.println("Impuesto procultura: "+i.proCulturaTaxPercent());
					return true;
				}
				
			}else if(select==2) {
				ArrayList<Education> objectList=principal.getEducation();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					Education i=objectList.get(select-1);
					System.out.println("name: "+i.getName());
					System.out.println("Nit: "+i.getNit());
					System.out.println("Direccion correspondiente: "+i.getDirCorrespon());
					System.out.println("Telefono: "+i.getTel());
					System.out.println("# Empleados: "+i.getEmployeeCuant());
					System.out.println("Valor actPesos pesos: "+i.getActPesos());
					System.out.println("Fecha Constitucion: "+i.getConsDate().toString());
					System.out.println("Nombre del representante legal: "+i.getLegalRepreName());
					System.out.println("Numero anios acreditado: "+i.getYearAcredit());
					System.out.println("Nac Saber 11: "+i.getNacSaber11());
					System.out.println("Nac Saber PRO: "+i.getNacSaberPro());
					System.out.println("Nombre del rector: "+i.getPrincipalName());
					System.out.println("Sector educativo: "+i.getEducationSector());
					System.out.println("Suscriptores Totales: "+i.getTotalSubs());
					System.out.println("Suscriptores Totales: "+i.getTotalSubs());
					System.out.println("Suscriptores estrato 1 y 2: "+i.getStratum1and2Subs());
					System.out.println("Registro aprovado MEN: "+i.getRegisAproMen());
					System.out.println("Impuesto procultura: "+i.objectList.get(index).proCulturaTaxPercent());
					return true;
				}	
			}else if(select==3) {
				ArrayList<Technology> objectList=principal.getTechnology();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					Technology i=objectList.get(select-1);
					System.out.println("name: "+i.getName());
					System.out.println("Nit: "+i.getNit());
					System.out.println("dirCorrespon: "+i.getDirCorrespon());
					System.out.println("Telefono: "+i.getTel());
					System.out.println("# Empleados: "+i.getEmployeeCuant());
					System.out.println("Valor actPesos pesos: "+i.getActPesos());
					System.out.println("Fecha Constitucion: "+i.getConsDate().toString());
					System.out.println("Nombre del representante legal: "+i.getLegalRepreName());
					System.out.println("Tipo de Servicio: "+i.getService());
					System.out.println("Energia anual: "+i.getanualEnergy());
					System.out.println("Impuesto procultura: "+i.proCulturaTaxPercent());
					System.out.println("Arboles que debe de plantar al anio: "+i.objectList.get(index).energyXTree());
					
					return true;
				}	
			}
		}else {
			System.out.println("Ingrese 1 para mostrar info de empresas de Fabricacion(Normal)");
			System.out.println("Ingrese 2 para mostrar info de empresas de Fabricacion(Medicamento)");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				
				ArrayList<Fabrication> objectList=principal.getFabricationOrg();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					Fabrication i=objectList.get(select-1);
					System.out.println("name: "+i.getName());
					System.out.println("Nit: "+i.getNit());
					System.out.println("Direccion correspondiente: "+i.getDirCorrespon());
					System.out.println("Telefono: "+i.getTel());
					System.out.println("# Empleados: "+i.getEmployeeCuant());
					System.out.println("Valor actPesos pesos: "+i.getActPesos());
					System.out.println("Fecha Constitucion: "+i.getConsDate().toString());
					System.out.println("Nombre del representante legal: "+i.getLegalRepreName());
					System.out.println("Impuesto procultura: "+i.proCulturaTaxPercent());
				
			}else if(select==2) {
				ArrayList<MedFabrication> objectList=principal.getMedFabrication();
				for (int i = 0; i < objectList.size(); i++) {
					System.out.println((i+1)+" "+objectList.get(i).toString());
				}
				select = Integer.parseInt(br.readLine());
				if(select>0&&select<=objectList.size()) {
					MedFabrication i=objectList.get(select-1);
					System.out.println("name: "+i.getName());
					System.out.println("Nit: "+i.getNit());
					System.out.println("Direccion correspondiente: "+i.getDirCorrespon());
					System.out.println("Telefono: "+i.getTel());
					System.out.println("# Empleados: "+i.getEmployeeCuant());
					System.out.println("Valor actPesos pesos: "+i.getActPesos());
					System.out.println("Fecha Constitucion: "+i.getConsDate().toString());
					System.out.println("Nombre del representante legal: "+i.getLegalRepreName());
					System.out.println("Impuesto procultura: "+i.proCulturaTaxPercent());
					System.out.println("Arboles que debe de plantar al anio: "+i.objectList.get(index).waterXTree());
			}
		}
		return false;
		
	}
	private boolean register() throws Exception {
		System.out.println("Ingrese 1 para registar empresa de Fabrication");
		System.out.println("Ingrese 2 para registar empresa de servicios");
		int select = Integer.parseInt(br.readLine());
		if(select==1) {
			System.out.println("Ingrese 1 para registar empresa de Servicios Publicos");
			System.out.println("Ingrese 2 para registar empresa de Education");
			System.out.println("Ingrese 3 para registar empresa de Technology");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				consDate.setDate(28);
				consDate.setMonth(8);
				consDate.setYear(1898);
				String name="EnergiPepsico";
				String nit="456488";
				String dirCorrespon="Cl 31b# 5(Cali)";
				String tel="3135599";
				int employeeCuant=190000;
				int actPesos=89000;
				OrgType type=OrgType.Constru;
				String legalRepreName= "Pepito";
				
				Cubicle[][][] building=new Cubicle[7][7][7];
				PublicServiceType f=PublicServiceType.ENERGIA;
				PublicServices nuevo=new PublicServices(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate, type, legalRepreName, f, 8000, 2000, building);
				principal.addServicioEmp(nuevo);
				
				return true;
			}else if(select==2) {
				Date consDate=new Date();
				consDate.setDate(28);
				consDate.setMonth(8);
				consDate.setYear(1898);
				String name="TuIcesiEjemplista";
				String nit="456445";
				String dirCorrespon="Cl 21 b# 5(Cali)";
				String tel="31344339";
				int employeeCuant=1900;
				int actPesos=79000;
				OrgType type=OrgType.Manufactu;
				String legalRepreName= "Percheroso";
				int regisAproMen= 12;
				int yearAcredit= 21;
				int nacSaber11= 2;
				int nacSaberPro= 3;
				String principalName= "Albeiro";
				String educationSector= HIGHSCHOOL;
				int stratum1and2Act= 21;
				int totalActStudents= 53;
				
				Cubicle[][][] building=new Cubicle[5][6][7];
				Education nuevo=new Education(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate, type, legalRepreName, regisAproMen, yearAcredit, nacSaber11, nacSaberPro, principalName, stratum1and2Act, totalActStudents, 8000, 2000, building);
				principal.addServicioEmp(nuevo);
				return true;
			}else if(select==3) {
					Date consDate=new Date();
				consDate.setDate(28);
				consDate.setMonth(8);
				consDate.setYear(1898);
				String name="CarullaCoSteller";
				String nit="421414141";
				String dirCorrespon="Cl 11# 12-12(bogota)";
				String tel="31322449";
				int employeeCuant=273000;
				int actPesos=10000;
				OrgType type=OrgType.ComunalesSociales;
				String legalRepreName= "Fernanda";
				Cubicle[][][] building=new Cubicle[3][5][4];
				Technology nuevo=new Technology(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate, type, legalRepreName, 8000, 2000, building);
				principal.addServicioEmp(nuevo);
				return true;
			}
		}else {
			System.out.println("Ingrese 1 para registar empresa de Fabrication(Normal)");
			System.out.println("Ingrese 2 para registar empresa de Fabrication(Medicamento)");
			select = Integer.parseInt(br.readLine());
			if(select==1) {
				Date consDate=new Date();
				consDate.setDate(28);
				consDate.setMonth(8);
				consDate.setYear(1898);
				String name="PolatronCO";
				String nit="421245241";
				String dirCorrespon="Cl 11# 12-12(medellin)";
				String tel="3185990453";
				int employeeCuant=27323000;
				int actPesos=1001100;
				OrgType type=OrgType.ComunalesSociales;
				String legalRepreName= "Manuela";
				Cubicle[][][] building=new Cubicle[3][5][4];
				Technology nuevo=new Technology(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate, type, legalRepreName, 8000, 2000, building);
				principal.addFabricacionEmp(nuevo);
				return true;
			}else if(select==2) {
				Date consDate=new Date();
				consDate.setDate(28);
				consDate.setMonth(8);
				consDate.setYear(1898);
				String name="PolatronCO";
				String nit="421245241";
				String dirCorrespon="Cl 11# 12-12(medellin)";
				String tel="3185990453";
				int employeeCuant=27323000;
				int actPesos=1001100;
				OrgType type=OrgType.ComunalesSociales;
				String legalRepreName= "Manuela";
				Cubicle[][][] building=new Cubicle[3][5][4];
				Technology nuevo=new Technology(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate, type, legalRepreName, 8000, 2000, building);
				principal.addFabricacionEmp(nuevo);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		Main in =new Main();
		in.ejecut();
	}
}
