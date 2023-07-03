items_ids = input('Item: ')

list_of_items = items_ids.split(",")

for item in list_of_items:
    with open(file=f"..\src\main/resources/assets\delightfulcreators\models\item/{item}.json", mode="a", encoding="utf-8") as file:
        file.write('{\n'
                   '    "parent": "item/generated",\n'
                   '    "textures": {\n'
                   f'        "layer0": "delightfulcreators:item/{item}"\n'
                   '    }\n'
                   '}')
    print("Done: ", item)