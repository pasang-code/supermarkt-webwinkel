

INSERT INTO merk (id, name, slogan, founding_year) VALUES
                                                       (1, 'Coca-Cola', 'Taste the Feeling', '1892'),
                                                       (2, 'Nestlé', 'Good Food Good Life', '1866'),
                                                       (3, 'Danone', 'One Planet One Health', '1919'),
                                                       (4, 'Lay''s', 'Betcha Can''t Eat Just One', '1932'),
                                                       (5, 'Heinz', '57 Varieties', '1869');

----------------------------------
INSERT INTO product
(id, product_naam, beschrijving, prijs, gewicht, categorie, merk_id, biologisch, image_url)
VALUES
    (1, 'Coca-Cola Classic', 'Original Coca-Cola soft drink', 1.99, 1.5, 'Drank', 1, false, '/img/banana.jpg'),

    (2, 'Coca-Cola Zero', 'Zero sugar cola drink', 2.09, 1.5, 'Drank', 1, false, '/img/banana.jpg'),

    (3, 'KitKat', 'Chocolate wafer bar', 1.29, 0.045, 'Snacks', 2, false, '/img/banana.jpg'),

    (4, 'Nescafé Classic', 'Instant coffee', 4.99, 0.2, 'Drank', 2, false, '/img/banana.jpg'),

    (5, 'Activia Yogurt', 'Probiotic yogurt', 2.49, 0.5, 'Zuivel', 3, false, '/img/banana.jpg'),

    (6, 'Danone Natural Yogurt', 'Natural creamy yogurt', 2.19, 0.5, 'Zuivel', 3, false, '/img/banana.jpg'),

    (7, 'Lay''s Naturel Chips', 'Classic salted potato chips', 2.59, 0.2, 'Snacks', 4, false, '/img/banana.jpg'),

    (8, 'Lay''s Paprika Chips', 'Paprika flavored potato chips', 2.69, 0.2, 'Snacks', 4, false, '/img/banana.jpg'),

    (9, 'Heinz Tomato Ketchup', 'Classic tomato ketchup', 3.49, 0.5, 'Sauzen', 5, false, '/img/banana.jpg'),

    (10, 'Heinz Organic Ketchup', 'Organic tomato ketchup', 4.29, 0.5, 'Sauzen', 5, true, '/img/banana.jpg');
-----------------------------------------