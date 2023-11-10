db.getSiblingDB('admin');
db = db.auth(
    process.env.MONGO_INITDB_ROOT_USERNAME,
    process.env.MONGO_INITDB_ROOT_PASSWORD
);

db.getSiblingDB(process.env.MONGO_INITDB_DATABASE);