import test, { expect } from "@playwright/test";
import { productDetailResponse } from "../../helper/response/productResponse";
import { randomUUID } from "crypto";

test.describe("API Product Detail", () => {
  test("test with correct request", async ({ request }) => {
    const productDetail = await request.post("/view", {
      data: {
        id: "10",
      },
    });

    const responseBody = await productDetail.json()

    expect(productDetail.ok()).toBeTruthy();
    expect(responseBody).toEqual(productDetailResponse)
  })

  test("test add to cart api", async ({ request }) => {
    const productDetail = await request.post("/addtocart", {
      data: {
        "id": randomUUID(),
        "cookie": "Ym9vc3N0MTcxNzkxMw==",
        "prod_id": 10,
        "flag": true
      }
    });
    expect(productDetail.ok()).toBeTruthy();
  })

})
