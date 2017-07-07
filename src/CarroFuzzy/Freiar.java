package CarroFuzzy;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;
import net.sourceforge.jFuzzyLogic.rule.RuleExpression;
import net.sourceforge.jFuzzyLogic.rule.RuleTerm;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

import java.util.HashMap;
import java.util.List;
import net.sourceforge.jFuzzyLogic.plot.JDialogFis;

public class Freiar {
    public Freiar(){
        
    }
    
    public double freiarCarro(int farol, int distancia, int velocidade){
        //Carrega o arquivo com as regras
        String fileName = "fcl/Freiar.fcl";
        FIS fis = FIS.load(fileName, true);

        if (fis == null) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return 0.0;
        }

        //Variável que carrega o bloco de regras
        FunctionBlock functionBlock = fis.getFunctionBlock(null);

        //Atribuio os valores das variáveis de entrada
        functionBlock.setVariable("farol", farol);
        functionBlock.setVariable("distancia", distancia);
        functionBlock.setVariable("velocidade", velocidade);

        fis.evaluate();
        
        //JDialogFis jdf = new JDialogFis(fis, 800, 600);

        //HashMap<String, RuleBlock> todasRegras = new HashMap<String, RuleBlock>();
        //todasRegras = functionBlock.getRuleBlocks();

        //RuleBlock blocoDeRegras = todasRegras.get("No1");

        //List<Rule> regras;
        //regras = blocoDeRegras.getRules();

        //Variable f = functionBlock.getVariable("freiar");

        //Retorna o valor da variável de saída
        double freiar = fis.getVariable("freiar").getValue();
        System.out.println("Valor da saída frear: "+freiar);

        return freiar;
    }
}
