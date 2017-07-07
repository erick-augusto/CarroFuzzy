package CarroFuzzy;

import java.util.HashMap;
import java.util.List;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JDialogFis;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class VirarEsquerda {
    public VirarEsquerda(){
        
    }
    
    public double pistaEsquerda(int distancia_carro, int velocidade, boolean l_esquerda){
        //Carrega o arquivo com as regras
        String fileName = "fcl/Esquerda.fcl";
        FIS fis = FIS.load(fileName, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + fileName + "'");
            return 0.0;
        }

        //Variável que carrega o bloco de regras
        FunctionBlock functionBlock = fis.getFunctionBlock(null);

        int pista;
        if(l_esquerda){
            pista = 1;
        } else{
            pista = 0;
        }

        //Atribuio os valores das variáveis de entrada
        functionBlock.setVariable("distancia_carro", distancia_carro);
        functionBlock.setVariable("velocidade", velocidade);
        functionBlock.setVariable("pista_esquerda", pista);

        fis.evaluate();

        //HashMap<String, RuleBlock> todasRegras = new HashMap<String, RuleBlock>();
        //todasRegras = functionBlock.getRuleBlocks();

        //RuleBlock blocoDeRegras = todasRegras.get("No1");
        
        //List<Rule> regras;
        //regras = blocoDeRegras.getRules();
        
        //Variable e = functionBlock.getVariable("virar_esquerda");

        //Retorna o valor da variável de saída
        double esquerda = fis.getVariable("virar_esquerda").getValue();
        System.out.println("Valor da saída virar à esquerda: "+esquerda);
        
        return esquerda;
    }
}
