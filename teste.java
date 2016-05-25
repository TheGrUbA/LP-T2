
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);		
		
	
		Locale.setDefault(new Locale("en","US"));
		DecimalFormat df = new DecimalFormat("0.000");
		df.setRoundingMode(RoundingMode.HALF_DOWN);

		int i,qc,tipos[],min[];
		double precos[][],vconta[];
		precos = new double[3][2];
		String nomes[],fone[];
		System.out.println("Digite a quantidade de clientes: ");
		qc = sc.nextInt();
		
		
		fone = new String[qc];
		nomes = new String[qc];
		tipos = new int[qc];
		min = new int[qc];
		vconta = new double[qc];
		
		
				
		System.out.println("------Cadastro de Clientes------");
		for(i=0;i<qc;i++){
			System.out.println("Digite o nome do cliente "+(i+1)+":");
			sc.nextLine();
			nomes[i] = sc.nextLine();
			System.out.println("Digite o telefone do cliente "+(i+1)+":");			
			fone[i] = sc.nextLine();
			do{
				System.out.println("Digite o tipo (0,1 ou 2) de assinatura do cliente "+(i+1)+":");
				tipos[i] = sc.nextInt();
			}while(tipos[i] > 2 || tipos[i] < 0);
			System.out.println("Digite o quantidade de minutos consumidos do cliente "+(i+1)+":");
			min[i] = sc.nextInt();
		}
		
		
		System.out.println("------CADASTRO DA TABELA DE COBRANÇA------");
		for(i=0;i<3;i++){			
			System.out.println("ASSINATURA TIPO "+i+" --- Digite o preço da assinatura:");
			precos[i][0] = sc.nextDouble();
			System.out.println("ASSINATURA TIPO "+i+" --- Digite o preço do minuto excedente:");
			precos[i][1] = sc.nextDouble();			
		}
		for(i=0;i<qc;i++){
			if(min[i]<=90){				
				vconta[i] = precos[tipos[i]][0];
			}
			else{				
				vconta[i] = precos[tipos[i]][0] + ((min[i]-90) * precos[tipos[i]][1]);
			}
		}		
		System.out.println("------------------------------------------------------------------");
		System.out.println("NOME \t\t\t TELEFONE      TIPO  MINUTOS  VALOR CONTA");
		for(i=0;i<qc;i++){
			System.out.println(nomes[i]+"\t\t"+fone[i]+"\t"+tipos[i]+"	"+min[i]+"\t"+vconta[i]);
		}
		
		double receitaTotal = 0.0;
		for(i=0;i<qc;i++){
			receitaTotal = receitaTotal + vconta[i];
		}
		System.out.println("------------------------------------------------------------------");
		System.out.println("RECEITA TOTAL DA EMPRESA: "+receitaTotal+" reais");
		System.out.println("------------------------------------------");
		
		int menorPos;
		if(qc > 1){
		menorPos = 1;
			for(i=0;i<qc;i++){
				if(vconta[i] < vconta[menorPos]){
					menorPos = i;
				}
			}
		}
		else{
			menorPos = 0;
		}
		System.out.println("---CLIENTE QUE TEVE A CONTA MAIS BARATA---");
		System.out.println("NOME: "+nomes[menorPos]);
		System.out.println("TELEFONE: "+fone[menorPos]);
		System.out.println("VALOR DA CONTA: "+vconta[menorPos]+" reais");
		
		
		double media = 0.0;
		int soma = 0;
		int cont = 0;
		System.out.println("-----------------------------------------------------------------");
		for(i=0;i<qc;i++){
			if(tipos[i]==1){
				cont++;
				soma = soma+min[i];
			}
		}
		if(cont > 0)
			media = soma/cont;
		else
			media = 0.0;
		System.out.println("MÉDIA DE MINUTOS CONSUMIDOS POR CLIENTES DE CONTA TIPO 1: "+media);
		System.out.println("-----------------------------------------------------------------");
		
		System.out.println("NOMES E TELEFONES DOS CLIENTES QUE NÃO CONSUMIRAM MINUTOS EXCEDENTES:");
		for(i=0;i<qc;i++){
			if(min[i]<=90){				
				System.out.println("-------CLIENTE 1:-------");
				System.out.println("NOME: "+nomes[i]);
				System.out.println("TELEFONE: "+fone[i]);
			}
		}
		System.out.println("----------------------------------------------------------------------");
		
		
		cont = 0;
		
		for(i=0;i<qc;i++){
			if(min[i]>120){
				cont++;
			}
		}
		System.out.println("QUANTIDADE DE CLIENTES QUE CONSUMIU ACIMA DE 120 MINUTOS: "+cont);		
		System.out.println("----------------------------------------------------------------------");
		
		
			
		cont = 0;
		double porcentagem;
		for(i=0;i<qc;i++){
			if(tipos[i]==2){
				cont++;
			}
		}
		porcentagem = (100.0*cont)/qc;
		System.out.println("PORCENTAGEM DE CLIENTES QUE POSSUEM CONTA DO TIPO 2: "+porcentagem+"%");
		System.out.println("----------------------------------------------------------------------");
		
		sc.close();
	}

}
