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
levels[2] = [id: 2, dimension: 4, mines: [[x: 0, y: 1, z: 1],
										  [x: 3, y: 2, z: 2]]]
levels[3] = [id:3, dimension: 5, mines: [[x: 0, y: 1, z: 2],
										 [x: 3, y: 4, z: 0],
										 [x: 4, y: 2, z: 3]]]
levels[4] = [id:4, dimension: 6, mines: [[x: 1, y: 1, z: 1],
										 [x: 4, y: 4, z: 4],
										 [x: 4, y: 2, z: 1],
										 [x: 1, y: 3, z: 4]]]
levels[5] = [id:5, dimension: 7, mines: [[x: 0, y: 1, z: 2],
										 [x: 4, y: 5, z: 6],
										 [x: 6, y: 2, z: 1],
										 [x: 3, y: 6, z: 3],
										 [x: 1, y: 0, z: 6],]]


def level = levels[5]
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
def id = minefieldId * 1000

println "INSERT INTO level(id, size)VALUES (${level.id}, ${level.dimension});"
println ""

minefield.each {
	println "INSERT INTO sector(id, level_id, x, y, z, radiation, has_mine) VALUES (${id++}, $minefieldId, ${it.value.x}, ${it.value.y}, ${it.value.z}, ${it.value.radiation}, ${it.value.isMine});"
}