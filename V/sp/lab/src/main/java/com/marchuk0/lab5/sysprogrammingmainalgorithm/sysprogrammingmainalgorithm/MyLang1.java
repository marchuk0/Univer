package com.marchuk0.lab5.sysprogrammingmainalgorithm.sysprogrammingmainalgorithm;

import com.marchuk0.lab5.sysprogrammingmainalgorithm.sysprogrammingmainalgorithm.JavaTeacherLib.MyLang;
import com.marchuk0.lab5.sysprogrammingmainalgorithm.sysprogrammingmainalgorithm.JavaTeacherLib.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyLang1 extends MyLang {
    public MyLang1(String fileLang, int llk1) {
        super(fileLang, llk1);
    }

    @Override
    public boolean createNonProdRools() {
        if(this.getNonTerminals().length == 0){
            return true;
        }
        else {
            int[] prodTmp = new int[this.getNonTerminals().length];
            int count = 0;

            for(Node node: this.language) {
                node.setTag(0);
            }
            
            Node node;
            Iterator<Node> it;
            int i;
            boolean upr;
            int[] rule;
            
            again:
            do {
                upr = false;
                it = this.language.iterator();

                while(true) {
                    int ii1;
                    do {
                        do {
                            if (!it.hasNext()) continue again;

                            node = it.next();
                            rule = node.getRule();
                        } while (node.getTag() == 1);

                        for (i = 1; i < rule.length; ++i)
                            if (rule[i] <= 0) {
                                ii1 = 0;
                                while (ii1 < count && prodTmp[ii1] != rule[i])
                                    ++ii1;

                                if (ii1 == count) break;
                            }
                    } while (i != rule.length);

                    ii1 = 0;
                    while (ii1 < count && prodTmp[ii1] != rule[0])
                        ++ii1;

                    if (ii1 == count) prodTmp[count++] = rule[0];

                    node.setTag(1);
                    upr = true;
                }
            } while (upr);

            if (count == prodTmp.length) {
                System.out.print("В граматиці непродуктивні правила відсутні\n");
                return true;
            } else {
                printNonProdNonTerminals();
                return true;
            }
        }
    }
    
    private void printNonProdNonTerminals() {
        Set<String> prod = new HashSet<>();
        for (Node n: this.language) {
            if (n.getTag() == 1)
                prod.add(getLexemText(n.getRule()[0]));
        }
        Set<String> nonProd = new HashSet<>();
        for (Node n: this.language) {
            if (!prod.contains(getLexemText(n.getRule()[0]))) {
                nonProd.add(getLexemText(n.getRule()[0]));
            }
        }

        System.out.println("Непродуктивні нетермінали: \n");
        for (String s : nonProd) {
            System.out.println(s);
        }

    }
}
