package flame.unit;

import flame.*;
import flame.effects.*;
import flame.unit.empathy.*;
import mindustry.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.meta.*;

public class EmpathyUnitType extends UnitType{
    public EmpathyUnitType(String name){
        super(name);
        flying = true;
        hitSize = 7;
        drag = 0.07f;

        health = 100f;

        outlines = false;
        drawCell = false;
        bounded = false;

        createScorch = false;
        hidden = true;

        engineSize = -1f;

        controller = u -> new NullAI();

        envEnabled = Env.any;
        envDisabled = 0;
        constructor = UnitEntity::create;

        deathExplosionEffect = FlameFX.empathyDecoyDestroy;
        deathSound = FlameSounds.expDecoy;

        description = """
                Its prison was enlisted for the outerversal war. However due to a mistake that suddenly end the war, costing most of the lives of those who oppose the End.
                Their bodies either annihilated, distort, or suddenly shifted; as their form is not supported in this sector of reality, only held together by the Kami.
                Those who survived either died from the forces of End, or stranded in this reality.
                The Prison Apathy wanders the universe aimlessly, waiting for its purpose to unleash the force inside it. Its unknown whether this force could compete with the End before the "Weakening".
                """;
    }

    @Override
    public void init(){
        super.init();
        for(StatusEffect s : Vars.content.statusEffects()){
            immunities.add(s);
        }
    }

    @Override
    public void load(){
        super.load();
        EmpathyRegions.load();
    }

    @Override
    public void update(Unit unit){
        if(!(unit instanceof EmpathyUnit)){
            unit.destroy();
            return;
        }
        super.update(unit);
    }
}
