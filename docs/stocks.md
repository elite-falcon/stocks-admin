# stocks-market-admin / stocks

Manage Stocks Resource

### Path

```
<host>:<port>/stocks/v1
```

### Methods

  `GET` `POST` `PATCH` `DELETE`

### Operations


---

#### Get Stocks

```
GET /stocks/v1
```  

* **Success Response:**
  * **Code:** `200`
  * **Content:** `data: [{ "stock": "string" }], status: 200`


---

#### Get Stock by Id

```
GET /stocks/v1/{id}
```

* **Params:**
  * **id:** `"string"`

* **Success Response:**
  * **Code:** `200`
  * **Content:** `data: { "stock": "string" }, status: 200`


---

#### Post Stock(s)

```
POST /stocks/v1
```
  
* **Payload:**
  * **data:** `[{ "stock": "string" }]`

* **Success Response:**
  * **Code:** `201`
  * **Content:** `Stock(s) Successfully Created`


---

#### Update Stock by Id

```
PATCH /stocks/v1/{id}
```

* **Params:**
  * **id:** `"string"`

* **Success Response:**
  * **Code:** `200`
  * **Content:** `Stock(s) Successfully Updated`


---

#### Delete Stock by Id

```
DELETE /stocks/v1/{id}
```

* **Params:**
  * **id:** `"string"`

* **Success Response:**
  * **Code:** `204`
  * **Content:** `Stock(s) Successfully Deleted`


---
 
### Sample Call

  ```javascript
    $.ajax({
      url: "/actuator/health",
      dataType: "json",
      type : "POST",
      success : function(r) {
        console.log(r);
      }
    });
  ```
  