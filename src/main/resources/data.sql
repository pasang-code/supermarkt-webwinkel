INSERT INTO merk (id, name, slogan, founding_year) VALUES
                                                       (1, 'Coca-Cola', 'Taste the Feeling', '1892'),
                                                       (2, 'Nestlé', 'Good Food Good Life', '1866'),
                                                       (3, 'Danone', 'One Planet One Health', '1919'),
                                                       (4, 'Lay''s', 'Betcha Can''t Eat Just One', '1932'),
                                                       (5, 'Heinz', '57 Varieties', '1869');

INSERT INTO category (id, name, description, image_url, featured, display_order) VALUES
                                                                                     (1, 'Drank', 'Frisdranken en koffie', '/img/categories/drank.jpg', true, 1),
                                                                                     (2, 'Snacks', 'Chips en zoete snacks', '/img/categories/snacks.jpg', true, 2),
                                                                                     (3, 'Zuivel', 'Yogurt en melkproducten', '/img/categories/zuivel.jpg', false, 3),
                                                                                     (4, 'Sauzen', 'Sauzen en condiments', '/img/categories/sauzen.jpg', false, 4);

INSERT INTO product
(id, product_naam, beschrijving, prijs, gewicht, categorie, merk_id, biologisch, image_url)
VALUES
    (1, 'Coca-Cola Classic 1.5L', 'Original Coca-Cola soft drink', 2.19, 1.5, 'Drank', 1, false, '/img/coca_cola_classic.jpg'),

    (2, 'Coca-Cola Zero Sugar 1.5L', 'Zero sugar cola drink', 2.19, 1.5, 'Drank', 1, false, '/img/coca_cola_zero.jpg'),

    (3, 'KitKat 4 Finger', 'Chocolate coated wafer bar', 1.39, 0.045, 'Snacks', 2, false, '/img/kitkat.jpg'),

    (4, 'Nescafé Classic Instant Coffee', 'Rich instant coffee', 5.49, 0.2, 'Drank', 2, false, '/img/nescafe.jpg'),

    (5, 'Activia Natural Yogurt', 'Probiotic yogurt for digestion', 2.69, 0.5, 'Zuivel', 3, false, '/img/activia.jpg'),

    (6, 'Danone Greek Style Yogurt', 'Creamy Greek style yogurt', 2.49, 0.5, 'Zuivel', 3, false, '/img/danone_yogurt.jpg'),

    (7, 'Lay''s Classic Chips', 'Classic salted potato chips', 2.79, 0.2, 'Snacks', 4, false, '/img/lays_classic.jpg'),

    (8, 'Lay''s Paprika Chips', 'Paprika flavored potato chips', 2.79, 0.2, 'Snacks', 4, false, '/img/lays_paprika.jpg'),

    (9, 'Heinz Tomato Ketchup', 'Classic tomato ketchup', 3.69, 0.5, 'Sauzen', 5, false, '/img/heinz_ketchup.jpg'),

    (10, 'Heinz Organic Tomato Ketchup', 'Organic tomato ketchup', 4.49, 0.5, 'Sauzen', 5, true, '/img/heinz_organic_ketchup.jpg');

INSERT INTO product_categories (products_id, categories_id) VALUES
                                                               (1, 1),
                                                               (2, 1),
                                                               (3, 2),
                                                               (7, 2),
                                                               (8, 2),
                                                               (4, 1),
                                                               (5, 3),
                                                               (6, 3),
                                                               (9, 4),
                                                               (10, 4);