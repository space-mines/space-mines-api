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

int dimension = 3

def mine = [x: 0, y: 0, z: 0]
def mines = [mine]
def minefield = [:]

for(int x = 0; x < dimension; ++x) {
	for(int y = 0; y < dimension; ++y) {
		for(int z = 0; z < dimension; ++z) {
			String key = getKey(x, y, z)
			minefield[key] = new Sector(x: x, y: y, z: z)
		}
	}
}

mines.each {
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

def minefieldId = 1
def id = minefieldId * 100

minefield.each {
	println "INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (${id++}, $minefieldId, ${it.value.x}, ${it.value.y}, ${it.value.z}, ${it.value.radiation}, ${it.value.isMine});"
}