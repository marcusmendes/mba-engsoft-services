from pymongo import MongoClient
import pymongo

MONGODB_URI = 'mongodb://mongodb/app'


def seed_database():
    print("Init Seed database...")
    client = MongoClient(MONGODB_URI)
    database = client.get_database(name='app')
    products_collection = database.get_collection(name='products')
    products_collection.drop()

    for i in range(1, 1000):
        product = {
            "name": "Ship Your Idea {}".format(i),
            "slug": "ship-your-idea-{}".format(i),
            "permalink": "https://example.com/product/ship-your-idea-22/",
            "date_created": "2017-03-23T17:03:12",
            "date_created_gmt": "2017-03-23T20:03:12",
            "date_modified": "2017-03-23T17:03:12",
            "date_modified_gmt": "2017-03-23T20:03:12",
            "type": "variable",
            "status": "publish",
            "featured": False,
            "catalog_visibility": "visible",
            "description": "<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>\n",
            "short_description": "<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>\n",
            "sku": "PRODUCT_01",
            "price": "129.90",
            "regular_price": "119.90",
            "sale_price": "129.90",
            "date_on_sale_from": "2017-03-23T17:03:12",
            "date_on_sale_to": "2017-03-23T17:03:12",
            "image": "https://media.istockphoto.com/photos/mountain-landscape-picture-id517188688?k=20&m=517188688&s=612x612&w=0&h=i38qBm2P-6V4vZVEaMy_TaTEaoCMkYhvLCysE7yJQ5Q="
        }

        products_collection.insert_one(product)
    print('Seed database finished.')
    client.close()


if __name__ == '__main__':
    seed_database()
