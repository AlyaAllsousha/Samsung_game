class Robot(health: Double = healthMax,
            power: Double,
            type:type,
            private var battery:Double
):Human(health, power, type){
    override fun attack(damage:Double, person: Human) {
        if(battery > 0.7){
            person.health -= ((power*(1+(battery/2)))*damage)
            battery-=0.5
        }
        else
            person.health -= ((power*battery)*damage)
    }



    override fun heal(hp: Double) {
        if (health + hp <= healthMax) {
            health += hp
        } else {
            health = healthMax
        }
        if ((battery + hp / 100) < 1)
            battery += hp / 100
        else {
            battery = 1.0
        }
    }

    override fun toString(): String {
        return ("$type,  health: $health, power: $power, battery:$battery")
    }
}