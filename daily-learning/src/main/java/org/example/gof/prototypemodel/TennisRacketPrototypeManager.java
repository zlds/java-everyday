package org.example.gof.prototypemodel;

import java.util.Hashtable;

/**
 * @author: hanchaowei
 * @date 2023/4/29
 * @description:
 */

public class TennisRacketPrototypeManager {
	private static Hashtable<String,RacketPrototype> racketMap = new Hashtable<>();

	public static RacketPrototype getCloneRacket(String model) {
		RacketPrototype r = racketMap.get(model);
		return (RacketPrototype) r.clone();
	}

	public static void buildProtypes() {
		WilsonTennisRacket r1 = new WilsonTennisRacket("Wilson", "Pro Staff 97", 315, 310);
		racketMap.put("pro staff", r1);
		HeadTennisRacket h1 = new HeadTennisRacket("Head", "Graphene 360+ Gravity Pro", 315, 310);
		racketMap.put("graphene 360", h1);
	}



}
