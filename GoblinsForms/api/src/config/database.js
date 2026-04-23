const { Pool } = require('pg');

const db = new Pool({
  user: 'admin',          
  host: 'localhost',      
  database: 'goblins_db', 
  password: 'password123',
  port: 5432,             
});

db.connect((err, client, release) => {
  if (err) {
    return console.error('Erro ao conectar ao PostgreSQL:', err.stack);
  }
  console.log('Conectado ao PostgreSQL com sucesso!');
  release(); 
});

module.exports = db;