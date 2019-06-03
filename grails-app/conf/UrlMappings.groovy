class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"( controller:"principalZoo")
		"500"(view:'/error')
	}
}
