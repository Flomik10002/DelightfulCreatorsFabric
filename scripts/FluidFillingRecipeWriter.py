mod_id = input("Enter mod_id: ")
item_id = input('Enter Item: ')
into_id = input('Enter Into: ')

list_of_items = item_id.split(",")

for item in list_of_items:
    with open(file=f"..\src\main/resources\data/{mod_id}/recipes/filling/{item}.json", mode="a",
              encoding="utf-8") as file:
        file.write('{\n'
                   '    "replace": "true",\n'
                   '    "type": "create:filling",\n'
                   '    "fabric:load_conditions": [\n'
                   '        {\n'
                   '            "condition": "fabric:all_mods_loaded",\n'
                   f'            "values": ["create", "farmersdelight", "{mod_id}"]\n'
                   '        }\n'
                   '    ],\n'
                   '    "ingredients": [\n'
                   '        {\n'
                   f'            "item": "minecraft:{into_id}"\n'
                   '        },\n'
                   '        {\n'
                   f'            "fluid": "delightfulcreators:{item}",\n'
                   '            "amount": 20250\n'
                   '        }\n'
                   '    ],\n'
                   '    "results": [\n'
                   '        {\n'
                   f'            "item": "{mod_id}:{item}"\n'
                   '        }\n'
                   '    ]\n'
                   '}')
    print("Done: ", item)