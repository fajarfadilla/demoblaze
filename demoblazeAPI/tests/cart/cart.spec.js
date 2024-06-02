import test, { expect } from "@playwright/test"

test.describe("test cart API", () => {
  test.beforeAll("test add to cart api", async ({ request }) => {
    const productDetail = await request.post("/addtocart", {
      data: {
        "id": "1",
        "cookie": "Ym9vc3N0MTcxNzkxMw==",
        "prod_id": 10,
        "flag": true
      }
    });
    expect(productDetail.ok()).toBeTruthy();
  })

  test("test API delete item from cart", async ({ request }) => {
    const viewCart = await request.post("/viewcart", {
      data: {
        cookie: "Ym9vc3N0MTcxNzkxMw==",
        flag: true
      },
    });
    expect(viewCart.ok()).toBeTruthy()
  })

  test("test API delete item from cart", async ({ request }) => {
    const deleteCart = await request.post("/deleteitem", {
      data: {
        id: "1",
      },
    });
    expect(deleteCart.ok).toBeTruthy()
  })

})
