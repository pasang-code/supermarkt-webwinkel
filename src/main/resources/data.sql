INSERT INTO merk (id, name, slogan, founding_year) VALUES
                                                       (1, 'Coca-Cola', 'Taste the Feeling', '1892'),
                                                       (2, 'Nestlé', 'Good Food Good Life', '1866'),
                                                       (3, 'Danone', 'One Planet One Health', '1919'),
                                                       (4, 'Lay''s', 'Betcha Can''t Eat Just One', '1932'),
                                                       (5, 'Heinz', '57 Varieties', '1869');


INSERT INTO category (id, name, description, image_url, featured, display_order) VALUES
                                                                                     (1, 'Drank', 'Frisdranken en koffie', '/img/categories/drank.jpg', false, 1),
                                                                                     (2, 'Snacks', 'Chips en zoete snacks', '/img/categories/snacks.jpg', false, 2),
                                                                                     (3, 'Zuivel', 'Yogurt en melkproducten', '/img/categories/zuivel.jpg', false, 3),
                                                                                     (4, 'Sauzen', 'Sauzen en condiments', '/img/categories/sauzen.jpg', false, 4),
                                                                                     (5, 'SuperDeals', 'Sterk afgeprijsde producten en tijdelijke acties', '/img/categories/superdeals.jpg', true, 5),
                                                                                     (6, 'Nieuwkomers', 'Nieuwe producten in ons assortiment', '/img/categories/nieuwkomers.jpg', true, 6),
                                                                                     (7, 'BestSellers', 'Onze meest populaire producten', '/img/categories/bestsellers.jpg', true, 7);



INSERT INTO product
(id, product_naam, beschrijving, prijs, gewicht, merk_id, biologisch, image_url)
VALUES
    (1, 'Coca-Cola Classic 1.5L', 'Original Coca-Cola soft drink', 2.19, 1.5, 1, false, '/img/coca_cola_classic.jpg'),

    (2, 'Coca-Cola Zero Sugar 1.5L', 'Zero sugar cola drink', 2.19, 1.5, 1, false, '/img/coca_cola_zero.jpg'),

    (3, 'KitKat 4 Finger', 'Chocolate coated wafer bar', 1.39, 0.045,  2, false, '/img/kitkat.jpg'),

    (4, 'Nescafé Classic Instant Coffee', 'Rich instant coffee', 5.49, 0.2, 2, false, '/img/nescafe.jpg'),

    (5, 'Activia Natural Yogurt', 'Probiotic yogurt for digestion', 2.69, 0.5, 3, false, '/img/activia.jpg'),

    (6, 'Danone Greek Style Yogurt', 'Creamy Greek style yogurt', 2.49, 0.5, 3, false, '/img/danone_yogurt.jpg'),

    (7, 'Lay''s Classic Chips', 'Classic salted potato chips', 2.79, 0.2, 4, false, '/img/lays_classic.jpg'),

    (8, 'Lay''s Paprika Chips', 'Paprika flavored potato chips', 2.79, 0.2, 4, false, '/img/lays_paprika.jpg'),

    (9, 'Heinz Tomato Ketchup', 'Classic tomato ketchup', 3.69, 0.5, 5, false, '/img/heinz_ketchup.jpg'),

    (10, 'Heinz Organic Tomato Ketchup', 'Organic tomato ketchup', 4.49, 0.5, 5, true, '/img/heinz_organic_ketchup.jpg');

INSERT INTO product_categories (products_id, categories_id) VALUES

-- DRANK
(1, 1),
(2, 1),
(4, 1),

-- SNACKS
(3, 2),
(7, 2),
(8, 2),

-- ZUIVEL
(5, 3),
(6, 3),

-- SAUZEN
(9, 4),
(10, 4),

-- SUPER DEALS (temporary discounts)
(2, 5),
(3, 5),
(7, 5),

-- NIEUWKOMERS (new products)
(6, 6),
(8, 6),
(10, 6),

-- BESTSELLERS (popular items)
(1, 7),
(3, 7),
(7, 7),
(9, 7);