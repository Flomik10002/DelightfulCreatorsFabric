mod_id = input("Enter mod_id: ")
item_id = input('Enter Item: ')
into_id = input('Enter Into: ')

list_of_items = item_id.split(",")

for item in list_of_items:
    with open(file=f"..\src\main/resources\data/{mod_id}/recipes/mixing/{item}.json", mode="a",
              encoding="utf-8") as file:
        file.write('{\n'
                   '    "type": "create:mixing",\n'
                   '    "heatRequirement": "heated",\n'
                   '    "fabric:load_conditions": [\n'
                   '        {\n'
                   '            "condition": "fabric:all_mods_loaded",\n'
                   f'            "values": ["create", "farmersdelight", "{mod_id}"]\n'
                   '        }\n'
                   '    ],\n'
                   '    "ingredients": [\n'
                   '        {\n'
                   f'            "fluidTag": "c:honey",\n'
                   '            "amount": 20250\n'
                   '        },\n'
                   '        {\n'
                   f'            "fluid": "delightfulcreators:{item}",\n'
                   '            "amount": 20250\n'
                   '        }\n'
                   '    ],\n'
                   '    "results": [\n'
                   '        {\n'
                   f'            "fluid": "{mod_id}:{item}"\n'
                   '            "amount": 40500'
                   '        }\n'
                   '    ]\n'
                   '}')
    print("Done: ", item)