package com.pma.user;

class UserRepositoryJdbc implements UserRepository {

    //private final JdbcTemplate jdbcTemplate;

    public UserRepositoryJdbc() {

    }

    @Override
    public void listAll() {
//        Collection<Order> orders = jdbcTemplate.query(
//                "SELECT id, customer FROM orders",
//                (rs, rowNum) -> Order.constructOrder(
//                        rs.getLong("id"),
//                        rs.getString("customer")));
//
//        orders.forEach(this::addItemsToOrder);
//
//        return orders;
    }

    @Override
    public void getById(long id) {
//        Order order = jdbcTemplate.queryForObject(
//                "SELECT id, customer FROM orders WHERE id = ?",
//                new Object[]{id},
//                (rs, rowNum) -> Order.constructOrder(
//                        rs.getLong("id"),
//                        rs.getString("customer")));
//
//        addItemsToOrder(order);


    }

    private void addItemsToOrder() {
//        jdbcTemplate.query(
//                "SELECT id FROM products JOIN orders_products ON id = product_id WHERE order_id = ?",
//                new Object[]{order.getId()},
//                (rs, rowNum) -> rs.getLong("id"))
//                .forEach(order::addItem);
    }

    @Override
    public void save() {
//        jdbcTemplate.update(
//                "INSERT INTO orders VALUES (?,?)",
//                new Object[]{
//                        order.getId(),
//                        order.getCustomer().getFullName()});
//
//        order.getItems().forEach(
//                item -> jdbcTemplate.update(
//                        "INSERT INTO orders_products VALUES (?,?)",
//                        new Object[]{order.getId(), item.getProductId()})
//        );
    }
}
