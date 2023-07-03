blocks_ids = input('Block: ')

list_of_blocks = blocks_ids.split(",")

for block in list_of_blocks:
    with open(file=f"..\src\main/resources/assets\delightfulcreators\models\block/{block}.json", mode="a", encoding="utf-8") as file:
        file.write('{\n'
                   '    "variants": {\n'
                   '        "": {\n'
                   f'           "model": "delightfulcreators:block/{block}"\n'
                   '        }\n'
                   '    }\n'
                   '}')
    print("Done: ", block)