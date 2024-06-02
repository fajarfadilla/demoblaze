// @ts-check
import test, { expect } from "@playwright/test";
import { monitorResponse, notebookResponse, phoneResponse } from "../../helper/response/categories/response";

test.describe("test product categories API", () => {
  test("valid request phone category", async ({ request }) => {
    const phoneCategoryAPi = await request.post("/bycat", {
      data: {
        cat: "phone",
      },
    });
    let responseBody = await phoneCategoryAPi.json();


    expect(phoneCategoryAPi.ok()).toBeTruthy();
    expect(responseBody).toEqual(phoneResponse);
  });

  test("valid request notebook category", async ({ request }) => {
    const notebookCategoryAPI = await request.post("/bycat", {
      data: {
        cat: "notebook",
      },
    });
    let responseBody = await notebookCategoryAPI.json();

    console.log(responseBody);

    expect(notebookCategoryAPI.ok()).toBeTruthy();
    expect(responseBody).toEqual(notebookResponse);
  });

  test("valid request monitor category", async ({ request }) => {
    const monitorCategoryAPI = await request.post("/bycat", {
      data: {
        cat: "monitor",
      },
    });
    let responseBody = await monitorCategoryAPI.json();

    console.log(responseBody);

    expect(monitorCategoryAPI.ok()).toBeTruthy();
    expect(responseBody).toEqual(monitorResponse);
  });

  test("test with empty request", async ({ request }) => {
    const phoneCategoryAPi = await request.post("/bycat", {
      data: {
        cat: "",
      },
    });
    let responseBody = await phoneCategoryAPi.json();


    expect(phoneCategoryAPi.ok()).toBeTruthy();
    expect(responseBody).toEqual({ Items: [] });
  });

})

