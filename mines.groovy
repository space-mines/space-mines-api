class Sector {

	int x
	int y
	int z
	boolean isMine = false
	int radiation = 0

}

String getKey(o) {
	"${o.x}-${o.y}-${o.z}"
}

String getKey(x, y, z) {
	"$x-$y-$z"
}

def levels = []
levels[1] =	[id:1, dimension: 3, mines: [x: 0, y: 0, z: 0]]
levels[2] = [id: 2, dimension: 4, mines: [[x: 1, y: 1, z: 1], [x: 2, y: 2, z: 2]]]

def level = levels[2]
def dimension = level.dimension

def minefield = [:]

for(int x = 0; x < dimension; ++x) {
	for(int y = 0; y < dimension; ++y) {
		for(int z = 0; z < dimension; ++z) {
			String key = getKey(x, y, z)
			minefield[key] = new Sector(x: x, y: y, z: z)
		}
	}
}

level.mines.each {
	String key = "${it.x}-${it.y}-${it.z}"
	Sector sector = minefield[key] as Sector
	sector.isMine = true
	sector.radiation = Integer.MAX_VALUE
	radiate(minefield, it.x, it.y, it.z)
}

def radiate(minefield, x1, y1, z1) {
	for(int x = -1; x < 2; ++x) {
		for(int y = -1; y < 2; ++y) {
			for(int z = -1; z < 2; ++z) {
				addRadiation(minefield, x1 + x, y1 + y, z1 + z)
			}
		}
	}
}

def addRadiation(minefield, x, y, z) {
	def key = getKey(x, y, z)
	def sector = minefield[key]
	if(sector && !sector.isMine) {
		sector.radiation++
	}
}

def minefieldId = level.id
def id = minefieldId * 100

println "INSERT INTO mine_field(id, size)VALUES (${level.id}, ${level.dimension});"
println ""

minefield.each {
	println "INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (${id++}, $minefieldId, ${it.value.x}, ${it.value.y}, ${it.value.z}, ${it.value.radiation}, ${it.value.isMine});"
}