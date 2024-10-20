import kotlin.math.abs

class knight(health: Double = healthMax,
             power: Double,
             type:type,
             private var defence:Double
             ):Human(health, power, type){
    override fun attack(damage: Double, person: Human) {
        person.health -= power*damage
    }

    override fun heal(hp: Double) {
        if(health + hp*0.9  <= healthMax){
            health+=hp*0.9
        }
        else{
            health= healthMax
        }
        if (health + defence <= healthMax)
            health += defence
        else{
            health= healthMax
        }
    }



    override fun toString(): String {
        return ("$type,  health: $health, power: $power, defence:$defence")

    }
}