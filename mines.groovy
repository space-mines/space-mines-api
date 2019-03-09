int id = 2

for(int x = 0; x < 3; ++x) {
	for(int y = 0; y < 3; ++y) {
		for(int z = 0; z < 3; ++z) {
println "INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (${id++}, 1, $x, $y, $z, 1);"
		}
	}
}
