const db = require('../config/database');

exports.listar = (callback) => {
  db.query('SELECT * FROM gnomes ORDER BY created_at DESC', (err, res) => {
    if (err) return callback(err);
    callback(null, res.rows);
  });
};

exports.criar = (name, atribute, callback) => {
  const query = 'INSERT INTO gnomes (name, atribute) VALUES ($1, $2) RETURNING id';
  const values = [name, atribute];

  db.query(query, values, (err, res) => {
    if (err) return callback(err);
    callback(null, res.rows[0]);
  });
};

exports.salvarFormula = (gnome_id, descricao, expressao, callback) => {
  const query = 'INSERT INTO formulas (gnome_id, descricao, expressao) VALUES ($1, $2, $3) RETURNING *';
  const values = [gnome_id, descricao, expressao];

  db.query(query, values, (err, res) => {
    if (err) return callback(err);
    callback(null, res.rows[0]);
  });
};

exports.listarPorGnomo = (gnome_id, callback) => {
  const query = 'SELECT * FROM formulas WHERE gnome_id = $1 ORDER BY created_at DESC';
  
  db.query(query, [gnome_id], (err, res) => {
    if (err) return callback(err);
    callback(null, res.rows);
  });
};

exports.listarTodasComGnomos = (callback) => {
  const query = `
    SELECT 
      f.id AS formula_id,
      f.descricao,
      f.expressao,
      f.created_at AS formula_data,
      g.name AS gnome_nome,
      g.atribute AS gnome_atributo
    FROM formulas f
    INNER JOIN gnomes g ON f.gnome_id = g.id
    ORDER BY f.created_at DESC
  `;

  db.query(query, (err, res) => {
    if (err) return callback(err);
    callback(null, res.rows);
  });
};

exports.deletarFormula = (id, callback) => {
  const query = 'DELETE FROM formulas WHERE id = $1 RETURNING *';

  db.query(query, [id], (err, res) => {
    if (err) return callback(err);
    if (res.rowCount === 0) return callback(new Error('Fórmula não encontrada'));
    callback(null, res.rows[0]); 
  });
};