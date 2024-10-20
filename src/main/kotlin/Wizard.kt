class Wizard(health: Double = healthMax,
             power: Double,
             type:type,
             private var mana:Double
            ) :Human(health, power, type){

    override fun attack( damage:Double,person:Human) {
        if (mana > 5) {
            person.health -= (power + mana) * damage
            mana-=1
        }
        else{
            person.health -= power*damage
        }
    }

    override fun heal(hp:Double) {
        if(health + hp  <= healthMax){
            health+=hp
        }
        else{
            health= healthMax
        }
        mana = if (mana+hp%10 <= 15.0) mana+hp%10 else 15.0
    }

    override fun toString(): String {
        return ("$type,  health: $health, power: $power, mana:$mana")

    }

}