package com.example;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class saveitems extends Activity {
	public Boolean bbb=true;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commanderpad);
        
        DBAdapter.context =this;
        Globala.saveitemcounter++;
	StringBuilder builde=new StringBuilder();
    builde.append(Globala.credits+",");
    builde.append(Globala.debt+",");
    builde.append(Globala.days+",");
    builde.append(Globala.warpSystem+",");
    builde.append(Globala.BuyPrice+",");
    builde.append(Globala.SellPrice+",");
    builde.append(Globala.policeKills+",");
    builde.append(Globala.traderKills+",");
    builde.append(Globala.pirateKills+",");
    builde.append(Globala.policeRecordScore+",");
    builde.append(Globala.reputationScore+",");
    builde.append(Globala.autoFuel+",");
    builde.append(Globala.autoRepair+",");
    builde.append(Globala.clicks+",");
    builde.append(Globala.encounterType+",");
    builde.append(Globala.raided+",");
    builde.append(Globala.monsterStatus+",");
    builde.append(Globala.dragonflyStatus+",");
    builde.append(Globala.japoriDiseaseStatus+",");
    builde.append(Globala.moonBought+",");
    builde.append(Globala.monsterHull+",");
    builde.append(Globala.CommanderName+",");
    builde.append(Globala.Ship+",");
    builde.append(Globala.Opponent+",");
    builde.append(Globala.Mercenary+",");
    builde.append(Globala.SolarSystem+",");
    builde.append(Globala.escapePod+",");
    builde.append(Globala.insurance+",");
    builde.append(Globala.noClaim+",");
    builde.append(Globala.inspected+",");
    builde.append(Globala.alwaysIgnoreTraders+",");
    builde.append(Globala.Wormhole+",");
    builde.append(Globala.diffculty+",");
    builde.append(Globala.pilotSkill+",");
    builde.append(Globala.fighterSkill+",");
    builde.append(Globala.traderSkill+",");
    builde.append(Globala.engineerSkill+",");
    builde.append(Globala.BuyingPrice+",");
    builde.append(Globala.artifactOnBoard+",");
    builde.append(Globala.reserveMoney+",");
    builde.append(Globala.leaveEmpty+",");
    builde.append(Globala.tribbleMessage+",");
    builde.append(Globala.alwaysInfo+",");
    builde.append(Globala.textualEncounters+",");
    builde.append(Globala.jarekStatus+",");
    builde.append(Globala.invasionStatus+",");
    builde.append(Globala.continuous+",");
    builde.append(Globala.experimentStatus+",");
    builde.append(Globala.wildStatus+",");
    builde.append(Globala.fabricRipProbability+",");
    builde.append(Globala.veryRareEncounter+",");
    builde.append(Globala.reactorStatus+",");
    builde.append(Globala.trackedSystem+",");
    builde.append(Globala.scarabStatus+",");
    builde.append(Globala.alwaysIgnoreTradeInOrbit+",");
    builde.append(Globala.showTrackedRange+",");
    builde.append(Globala.justLootedMarie+",");
    builde.append(Globala.arrivedViaWormhole+",");
    builde.append(Globala.trackAutoOff+",");
    builde.append(Globala.remindLoans+",");
    builde.append(Globala.canSuperWarp+",");
    builde.append(Globala.enablemusic+",");
    /*long Debt;
		
	
	
	Boolean trackAutoOff;
	Boolean remindLoans;
	Boolean canSuperWarp;
	Boolean musicEnabled;
	Byte ForFutureUse[MAXFORFUTUREUSE]; // Make sure this is properly adapted or savegames won't work after an upgrade!
}

    */
    String q=builde.toString();
    
    ids varibs=new ids();
    
    SCgame scgame1=new SCgame();
    scgame1.setName(q);
    scgame1.setName1(Globala.CommanderName);
   
    varibs.savegame(scgame1);
    Intent bb1=new Intent(saveitems.this,loadgame.class);
		startActivity(bb1);
  //  Cursor cursorGame = varibs.Selectgame();
}
}