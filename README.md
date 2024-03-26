
## API Reference

#### Insert Product metadata

```http
  POST /api/internal/products
```
Request Body

```
{
"productId": "MD-654613215",
"category": "Babies",
"brand": "Babyom"
}

```

#### Insert Shopper with Products

```http
  POST /api/internal/shopper/products
```
Request Body

```
{
"shopperId": "S-2000",
"shelf": [
          {
            "productId": "MB-2093193398",
            "relevancyScore": 31.089209569320897
          },
          {
            "productId": "BB-4653218",
            "relevancyScore": 55.16626010671777
          },
          {
            "productId": "MD-654613215",
            "relevancyScore": 73.01492966268303
          }
      ]
}

```

#### Get item

```http
  GET /api/external/products
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |
| `Category`      | `string` | **optional**. Product category |
| `Brand`      | `string` | **optional**. Product Brand |
| `Limit`      | `string` | **optional**. **default** = 10, **max** = 100 |



