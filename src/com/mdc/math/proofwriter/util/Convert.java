package com.mdc.math.proofwriter.util;

import java.util.HashMap;

/**
 * Created by Main on 5/4/16.
 */
public class Convert {
    public HashMap<String, String> shorthands = new HashMap<>();
    public Convert(){
        shorthands.put("ln","line");
        shorthands.put("sg","segment");
        shorthands.put("tri","△");
        shorthands.put("cong","≅");
        shorthands.put("pll","||");
        shorthands.put("perp","|");
        shorthands.put("dg","º");
        shorthands.put("pi","π");
        shorthands.put("sim","~");
        shorthands.put("ra","∟");
        shorthands.put("ang","∠");
        shorthands.put("pln","plane");

        shorthands.put("rect","rectangle");
        shorthands.put("pllg","parallelogram");
        shorthands.put("=ltr","equilateral");
        shorthands.put("=ang","equiangular");

        shorthands.put("def","definition");
        shorthands.put("poe","property of equality");
        
        shorthands.put("thm", "theorem");
    }

    public String convert(String s){
        String out = s.trim();
        for(String r : shorthands.keySet()){
            out = out.replace("[" + r, shorthands.get(r));
        }
        return out;
    }
}