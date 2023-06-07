package lab05;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


public abstract class Seguro {
	
		protected final int id;
		protected Date dataInicio;
		protected Date dataFim;
		protected Seguradora seguradora;
		protected ArrayList < Sinistro > listaSinistros = new ArrayList<Sinistro>();
		protected ArrayList < Condutor > listaCondutores = new ArrayList<Condutor>();
		protected double valorMensal;
		protected static int  num = 99999;
		
		// Construtor
		public Seguro(Date dataInicio, Date dataFim,Seguradora seguradora) {
			num++;
			
			this.dataInicio = dataInicio;
			this.dataFim = dataFim;
			this.seguradora = seguradora;
			this.listaSinistros = new ArrayList<Sinistro>();
			this.listaCondutores = new ArrayList<Condutor>();
			this.valorMensal = 0.0;
			this.id = num;
		}

			
		// Getters e setters
		
		public int getNum() {
			return num;
		}
		public int getId() {
			return id;
		}
		
		public void setNum(int num) { // atualiza a variavel estatica que atualiza o id
			Seguro.num = num;
		}
		
		public Date getDataInicio() {
			return dataInicio;
		}
		
		public void setDataInicio(Date dataInicio) {
			this.dataInicio = dataInicio;
		}
	
		public Date getDataFim() {
			return dataFim;
		}
		
		public void setDataFim(Date dataFim) {
			this.dataFim = dataFim;
		}
		
				
		public Seguradora getSeguradora() {
			return seguradora;
		}
		
		public void setSeguradora(Seguradora seguradora) {
			this.seguradora = seguradora;
		}
		
		public ArrayList<Sinistro> getListaSinistro(){
			return listaSinistros;
			}
		public void setListaSinistro(ArrayList<Sinistro> listaSinistros) {
			this.listaSinistros = listaSinistros;
		}
		
		public ArrayList<Condutor> getListaCondutores(){
			return listaCondutores;
			}
		public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
			this.listaCondutores = listaCondutores;
		}
		public double getValorMensal() {
			return valorMensal;
		}
		
		public void setValorMensal(double valorMensal)  {
			this.valorMensal = valorMensal;
		}

		// metodo para autorizar condutor 
			public boolean autorizarCondutor(Condutor condutor){
				for(Condutor condutor2 : getListaCondutores()) {
					if(condutor2.getCpf().equals(condutor.getCpf()) ) {  // verifica se esta na lista pelo cpf
						System.out.println("Esse condutor ja está autorizado");
						return false;
					} else {
						this.getListaCondutores().add(condutor); // (se nao esta na lista de condutores -> sera adicionado!)
						return true;
					}
				}
				return false;
			}
			
		
		// metodo para desautorizar condutor 
		public boolean desautorizarCondutor(Condutor condutor){
			for(Condutor condutor2 : getListaCondutores()) {
				if(condutor2.getCpf().equals(condutor.getCpf()) ) {  // verifica se esta na lista pelo cpf
					System.out.println("Condutor não autorizado");
					return false;
				} else {
					this.getListaCondutores().remove(condutor); // (se esta na lista de condutores -> sera removido!)
					return true;
				}
			}
			return false;
		}
		
		
		public boolean gerarSinistro(Date data, String endereco, Condutor condutor) {
			Sinistro sinistro = new Sinistro(data, endereco, condutor,this);
			
			if((!(this.getListaSinistro()).contains(sinistro))) { // se nao ja esta registrado, ele adiciona
				getListaSinistro().add(sinistro);
				System.out.println("Sinistro cadastrado com sucesso!");
				return true;
			} else {
				System.out.println("Sinistro já cadastrado");
				return false;  //se ja foi cadastrado, retorna falso
			}
			
		}
		
		public double calcularValor() throws ParseException {
			
			 // calculo do valor do seguro dependendo do tipo (PF ou PJ)
			
			 for(Seguro seguro : seguradora.getListaSeguro()) {
			 	if(seguro instanceof SeguroPF) {
			 		this.valorMensal =  ((SeguroPF) seguro).calcularValor(); // se seguro for PF chama a funcao de PF e atribui ao valor mensal
					
				} else if(seguro instanceof SeguroPJ) {
					this.valorMensal = ((SeguroPJ) seguro).calcularValor(); 
		
				} else {
					this.valorMensal = 0;
				}
			 }
			 return valorMensal;
		}
		
		
		
		
		
		 // toString()
		public String toString () {
			return "Seguro:" +
					"\n ID: " + this.id + 
					"\n Data início: " + this.dataInicio + 
					"\n Data fim: " + this.dataFim + 
					"\n Seguradora: " + this.seguradora.getNome() + 
					"\n Lista Sinistros: " + this.listaSinistros + 
					"\n Lista Condutores: " + this.listaCondutores + 
					"\n Valor mensal: R$ " + this.valorMensal + 
					"\n";
			
			}
	}

